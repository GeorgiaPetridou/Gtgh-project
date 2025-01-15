package com.example.demo.services;

import java.util.List;


import com.example.demo.users.Reservation;

public interface ReservationService {
    List<Reservation> removeAllReservationsForSpecificVisitor(Integer visitorID);
   
}