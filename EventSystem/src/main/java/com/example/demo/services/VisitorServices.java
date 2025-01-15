package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.users.GenerateQRCode;
import com.example.demo.users.Reservation;
import com.example.demo.users.Visitor;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
public class VisitorServices {

	 private ReservationService reservationService;
	

	private List<Visitor> visitors = new ArrayList<Visitor>();
	
	
	//Getters and Setters
	public List<Visitor> getAllVisitors() {
		return visitors;
	}

	public void setVisitors(List<Visitor> visitors) {
		this.visitors = visitors;
	}


	
	//Methods
	
	//give uniqVisitorId
	private Integer UniqVisitorID() {
	    return visitors.stream()
	            .mapToInt(Visitor::getID) 
	            .max() 
	            .orElse(0) + 1; 
	}
	
	
	//Add visitor to the list
	public Visitor addVisitor(Visitor visitor) {

        Integer visitorID = UniqVisitorID();
		
		visitor.setID(visitorID);
		visitors.add(visitor);
		return visitor;
	}
	
	//Remove visitor from the list
	public List<Visitor> removeVisitor(Integer ID) {
        Visitor visitorToRemove = visitors.stream()
                .filter(visitor -> visitor.getID().equals(ID))
                .findFirst()
                .orElse(null);

        if (visitorToRemove == null) {
            System.out.println("No visitor found with ID: " + ID);
            return visitors;
        }

        reservationService.removeAllReservationsForSpecificVisitor(ID);
        visitors.remove(visitorToRemove);
        return visitors;
    }

	

        
	//Update visitor's informations
	public List<Visitor> updateVisitor(Integer ID,String newName,String newSurname,String newEmail) {
		for (Visitor visitor : visitors) {
			if(visitor.getID().equals(ID)) {
				if(newName !=null) 
					visitor.setName(newName); 
				
				if(newSurname !=null) 
					visitor.setSurname(newSurname); 
				
				if(newEmail !=null) 
					visitor.setEmail(newEmail); 
			}
		}
		return visitors;
	
	}



	
	
	
	//QRCode
	public String generateVisitorQR(Integer visitorID, ReservationServices reservationServices) {
	    String QR_CODE_PATH = "src/main/resources/static/images/visitor_%d_qr.png";
	    
	    Visitor visitor = visitors.stream()
	            .filter(v -> v.getID().equals(visitorID))
	            .findFirst()
	            .orElseThrow(() -> new ResponseStatusException(
	                    HttpStatus.NOT_FOUND, "Visitor not found with ID: " + visitorID));

	    List<Reservation> visitorReservations = reservationServices.getReservationsByVisitor(visitorID);

	    if (visitorReservations.isEmpty()) {
	        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No reservations found for visitor with ID: " + visitorID);
	    }

	   
	    StringBuilder qrContent = new StringBuilder("Visitor Information:\n");
	    qrContent.append("Name: ").append(visitor.getName()).append("\n");
	    qrContent.append("Email: ").append(visitor.getEmail()).append("\n");
	    qrContent.append("Reservations:\n");

	    for (Reservation reservation : visitorReservations) {
	        qrContent.append("- Event: ").append(reservation.getEvent().getTitle()).append("\n");
	    }

	
	    String filePath = String.format(QR_CODE_PATH, visitorID);

	    try {
	    	GenerateQRCode.generateQRCodeImage(qrContent.toString(), 250, 250, filePath);
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error generating QR code.");
	    }

	    return filePath; 
	}

	
	
}
