package com.example.demo.services;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;


import com.example.demo.users.Event;
import com.example.demo.users.Reservation;
import com.example.demo.users.Visitor;

public class ReservationServices {
	
	
	@Autowired
	VisitorServices visitorservices;
	
	@Autowired
	EventServices eventservices;
	
	
	
	
	//Constructor
	private List<Reservation> allReservations = new ArrayList<Reservation>();

	
	//Getters and Setters
	public List<Reservation> getAllReservations() {
		return allReservations;
	}
	
	private Integer UniqReservationID() {
	    return allReservations.stream()
	            .mapToInt(Reservation::getID) 
	            .max() 
	            .orElse(0) + 1; 
	}


	//Methods

	public List<Reservation> makeReservation(Integer visitorID, Integer eventID) {
	    for (Visitor visitor : visitorservices.getAllVisitors()) {
	        if (visitor.getID().equals(visitorID)) { 
	            for (Event event : eventservices.getListOfEvents()) {
	                if (event.getID().equals(eventID)) { 
	                    if (event.getCountVisitors() < event.getMaxCapacity()) { 

	                       
	                        Integer reservationID = UniqReservationID();

	                      
	                        Reservation reservation = new Reservation(visitor, event, reservationID);
	                        allReservations.add(reservation); 
	                       

	                        System.out.println("New reservation created: " + reservation);
	                        return allReservations; 
	                    } else {
	                        System.out.println("No available seats for the event: " + event.getTitle());
	                        return null;
	                    }
	                }
	            }
	        }
	    }

	    System.out.println("Visitor or Event not found.");
	    return null;
	}

	

	// Remove a reservation from the list using reservationID
	public List<Reservation> removeReservation(Integer reservationID) {
	    for (Reservation reservation : allReservations) { 
	        if (reservation.getID().equals(reservationID)) { 
	             reservation.getEvent().removeToCountVisitors(); 
	            
	            allReservations.remove(reservation); 	
	            System.out.println("Reservation with ID: " + reservationID + " has been removed.");
	            return allReservations; 
	        }
	    }

	    System.out.println("No reservation found with ID: " + reservationID);
	    return allReservations; 
	}


	//Update reservation, update visitor's data
	
	public List<Reservation> updateReservationVisitorDetails(Integer reservationID, String newName, String newSurname, String newEmail) {
	    for (Reservation reservation : allReservations) { 
	        if (reservation.getID().equals(reservationID)) { 
	            Visitor visitor = reservation.getVisitor(); 	
	          
	            if (newName != null && !newName.isEmpty()) {
	                visitor.setName(newName);
	            }

	           
	            if (newSurname != null && !newSurname.isEmpty()) {
	                visitor.setSurname(newSurname);
	            }

	          
	            if (newEmail != null && !newEmail.isEmpty()) {
	                visitor.setEmail(newEmail);
	            }

	            System.out.println("Reservation with ID: " + reservationID + " has been updated with new visitor details.");
	            return allReservations; 
	        }
	    }

	    System.out.println("No reservation found with ID: " + reservationID);
	    return allReservations; 
	}

	
	
	
	//Get reservations by event
    
    public List<Reservation> getReservationsByEvent(String eventID) {
        return allReservations.stream()
                .filter(reservation -> reservation.getEvent().getID().equals(eventID))
                .collect(Collectors.toList());
    }


    //Get reservations by visitor


    public List<Reservation> getReservationsByVisitor(String visitorID) {
        return allReservations.stream()
                .filter(reservation -> reservation.getVisitor().getID().equals(visitorID))
                .collect(Collectors.toList());
    }

}
