package com.example.demo.services;


import java.util.ArrayList;
import java.util.List;


import com.example.demo.users.Event;
import com.example.demo.users.Reservation;
import com.example.demo.users.Visitor;

public class ReservationServices {
	
	
	
	//Constructor
	private List<Reservation> allReservations = new ArrayList<Reservation>();

	
	//Getters and Setters
	public List<Reservation> getAllReservations() {
		return allReservations;
	}


	//Methods

	public List<Reservation> makeReservation(String visitorId, String eventId, List<Visitor> visitors, List<Event> events) {
        for (Visitor visitor : visitors) {
            if (visitor.getID().equals(visitorId)) {
                for (Event event : events) {
                    if (event.getID().equals(eventId)) {
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
	public List<Reservation> removeReservation(){
		
		
		return allReservations;
	}
	
	
	
	
	
	//Get reservations by event
    public List<Reservation> getReservationsByEvent(Event event) {
        List<Reservation> result = new ArrayList<>();
        for (Reservation reservation : allReservations) {
            if (reservation.getEvent().equals(event)) {
                result.add(reservation);
            }
        }
        return result;
    }

    //Get reservations by visitor
    public List<Reservation> getReservationsByVisitor(Visitor visitor) {
        List<Reservation> result = new ArrayList<>();
        for (Reservation reservation : allReservations) {
            if (reservation.getVisitor().equals(visitor)) {
                result.add(reservation);
            }
        }
        return result;
    }

    //Print allreservations
    public void printAllReservations() {
        System.out.println("All Reservations:");
        for (Reservation reservation : allReservations) {
            System.out.println(reservation);
        }
    }
}
