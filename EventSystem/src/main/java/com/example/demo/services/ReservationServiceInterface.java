package com.example.demo.services;

import java.util.List;


import com.example.demo.users.Reservation;

public interface ReservationServiceInterface {
    List<Reservation> removeAllReservationsForSpecificVisitor(Integer visitorID);
   
}