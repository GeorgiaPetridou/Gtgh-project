package com.example.demo.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.services.ReservationServices;
import com.example.demo.users.Reservation;


@RestController
@RequestMapping("/reservations") 


public class ReservationController {
	

		@Autowired
		ReservationServices reservationServices;
		

		@GetMapping("/allreservations")
		public List<Reservation> getAllReservations(){
			return reservationServices.getAllReservations();	
		}
		
		@GetMapping("/reservationsByEvent")
		public List<Reservation> getReservationsByEvent(@RequestParam Integer eventID){
			return reservationServices.getReservationsByEvent(eventID);	
		}
		
		@GetMapping("/reservationsByVisitor")
		public List<Reservation> getReservationsByVisitor(@RequestParam Integer visitorID){
			return reservationServices.getReservationsByVisitor(visitorID);	
		}
		
		@PostMapping("/make")
		public Reservation makeReservation(@RequestParam Integer visitorID,@RequestParam Integer eventID){
			return reservationServices.makeReservation(visitorID, eventID);
		}
		
		@DeleteMapping("/remove")
		public List<Reservation> removeReservation(@RequestParam Integer reservationID,@RequestParam Integer visitorID){
			return reservationServices.removeReservation(reservationID, visitorID);
		}
		
		@PutMapping("/updateVisitorDetails")
		public Reservation updateVisitorDetails(@RequestParam Integer reservationID,@RequestParam (required = false) String newName, 
				@RequestParam (required = false) String newSurname,@RequestParam (required = false) String email){
			return reservationServices.updateReservationVisitorDetails(reservationID,newName, newSurname, email );
		}
		
		@GetMapping("/qrcode")
	    public String getVisitorQRCode(@PathVariable Integer visitorID) {
	        return reservationServices.generateQrCodeForReservation(visitorID);
	    }
}


