package com.example.demo.services;

import java.util.List;


import com.example.demo.users.Event;

public interface EventService {
	List<Event> approveEvent(Integer id);
	List<Event> denyEvent(Integer id);
	List<Event> deleteEvent(Integer id);
}
