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


	//Methods

	public List<Reservation> makeReservation(String visitorID, String eventID) {
        for (Visitor visitor : visitorservices.getAllVisitors()) {
            if (visitor.getID().equals(visitorID)) {
                for (Event event : eventservices.getListOfEvents()) {
                    if (event.getID().equals(eventID)) {
                        if (event.getCountVisitors() < event.getMaxCapacity()) {
                           
                            Reservation reservation = new Reservation(visitor, event);
                            allReservations.add(reservation); 
                            event.addToCountVisitors(); 
                            System.out.println("New reservation created for visitor: " + visitor.getName() +
                                    " for the event: " + event.getTitle());
                            return allReservations; 
                        } else {
                            System.out.println("Sorry, no available seats for the event: " + event.getTitle());
                            return allReservations; 
                        }
                    }
                }
            }
        }

        System.out.println("Visitor or Event not found.");
        return allReservations;
    }
	

	//Remove a reservation from the list using visitorid and eventid
	public List<Reservation> removeReservation(String visitorID, String eventID) {
	    for (Visitor visitor : visitorservices.getAllVisitors()) {
	        if (visitor.getID().equals(visitorID)) {
	            for (Event event : eventservices.getListOfEvents()) {
	                if (event.getID().equals(eventID)) {
	                    for (Reservation reservation : allReservations) {
	                        if (reservation.getVisitor().equals(visitor) && reservation.getEvent().equals(event)) {
	                            allReservations.remove(reservation); 
	                            event.removeToCountVisitors(); 
	                            System.out.println("Reservation removed for visitor: " + visitor.getName() +
	                                    " for the event: " + event.getTitle());
	                            return allReservations; 
	                        }
	                    }
	                    System.out.println("No reservation found for visitor: " + visitor.getName() +
	                            " and event: " + event.getTitle());
	                    return allReservations; 
	                }
	            }
	        }
	    }

	    System.out.println("Visitor or Event not found.");
	    return allReservations;
	}

	
	
	
	//Get reservations by event
//    public List<Reservation> getReservationsByEvent(Event event) {
//        List<Reservation> result = new ArrayList<>();
//        for (Reservation reservation : allReservations) {
//            if (reservation.getEvent().equals(event)) {
//                result.add(reservation);
//            }
//        }
//        return result;
//    }
    
    
    public List<Reservation> getReservationsByEvent(String eventID) {
        return allReservations.stream()
                .filter(reservation -> reservation.getEvent().getID().equals(eventID))
                .collect(Collectors.toList());
    }


    //Get reservations by visitor
//    public List<Reservation> getReservationsByVisitor(Visitor visitor) {
//        List<Reservation> result = new ArrayList<>();
//        for (Reservation reservation : allReservations) {
//            if (reservation.getVisitor().equals(visitor)) {
//                result.add(reservation);
//            }
//        }
//        return result;
//    }

    public List<Reservation> getReservationsByVisitor(String visitorID) {
        return allReservations.stream()
                .filter(reservation -> reservation.getVisitor().getID().equals(visitorID))
                .collect(Collectors.toList());
    }

}
