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


	
	
	//Add reservation from the reservationDb list
	public void removeReservation(Reservation reservation) {
		allReservations.remove(reservation -> resrvation.);
	}
	
	
	//Event reservations
	public List<Reservation> EventsReservations(Event event){
		List<Reservation> result = new ArrayList<>();
		for (Reservation reservation : allReservations) {
			if (reservation.getEvent().equals(event)) {
				result.add(reservation);
			}
		}
		return result;
	}
	
	
	//Visitor reservations
	public static List<Reservation> VisitorsReservations(Visitor visitor){
		List<Reservation> result = new ArrayList<>();
		for (Reservation reservation : allReservations) {
			if (reservation.getVisitor().equals(visitor)) {
				result.add(reservation);
			}
		}
		return result;
	}
	
	
	//print allReservations List
	public static void printAllReservations() {
		System.out.println("All Reservations:");
		for (Reservation reservation : allReservations) {
			System.out.println(reservation);
		}
	}
	
}

