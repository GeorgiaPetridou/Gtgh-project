package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.users.Visitor;
import org.springframework.stereotype.Service;
@Service
public class VisitorServices {

private ReservationServices reservationservices;
	
	//Constructor
	private List<Visitor> visitors = new ArrayList<Visitor>();
	
	
	//Getters and Setters
	public List<Visitor> getAllVisitors() {
		return visitors;
	}

	public void setVisitors(List<Visitor> visitors) {
		this.visitors = visitors;
	}


	public ReservationServices getReservationservices() {
		return reservationservices;
	}

	
	//Methods
	//Remove visitor from the list
	public List<Visitor> removeVisitor(Integer ID) {
		
		getReservationservices().removeAllReservationsForSpecificVisitor(ID);
		visitors.removeIf(visitor -> visitor.getID().equals(ID));
		return visitors;
	}
	
	
	
	
	//give uniqaVisitorId
	private Integer UniqVisitorID() {
	    return visitors.stream()
	            .mapToInt(Visitor::getID) 
	            .max() 
	            .orElse(0) + 1; 
	}
	
	
	//Add visitor to the list
	public List<Visitor> addVisitor(Visitor visitor) {

        Integer visitorID = UniqVisitorID();
		
		visitor.setID(visitorID);
		visitors.add(visitor);
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

	
	
	
	
}
