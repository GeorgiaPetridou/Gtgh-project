package com.example.demo.services;

import java.util.List;

import com.example.demo.users.Event;


public interface EventService {
	 List<Event> deleteEventWithoutRequest(Integer id, Integer employeeId);
	
}
