package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.EventServices;
import com.example.demo.users.Event;
import com.example.demo.users.Organizer;

@RestController
@RequestMapping("events")
public class EventController {

	@Autowired
	EventServices eventServices;
//	
//	@PostMapping("/add")
//	public Event addEvent(@RequestBody Event e,@RequestBody ){
//		return eventServices.addEvent(e);
//	}

	@DeleteMapping("/remove")
	public List<Event> removeEvent(@RequestParam Integer id) {
		return eventServices.removeEvent(id);
	}

	@GetMapping("/search")
	public List<Event> searchEvent(@RequestParam(required = false) String theme,
			@RequestParam(required = false) String location, @RequestParam(required = false) Integer day,
			@RequestParam(required = false) String month, @RequestParam(required = false) Integer year) {
		return eventServices.searchEvents(theme, location, day, month, year);
	}

	@GetMapping("/all")
	public List<Event> getAllEvents() {
		return eventServices.getAllEvents();
	}

	@PutMapping("/update")
	public List<Event> updateEvent(@RequestParam Integer idEvent, @RequestParam(required = false) String title,
			@RequestParam(required = false) String theme, @RequestParam(required = false) String description,
			@RequestParam(required = false) String location, @RequestParam(required = false) Integer maxCapacity,
			@RequestParam(required = false) Integer day, @RequestParam(required = false) String month,
			@RequestParam(required = false) Integer year, @RequestParam(required = false) Integer hour,
			@RequestParam(required = false) Integer minute, @RequestParam(required = false) Organizer organizer,
			@RequestParam(required = false) String status, @RequestParam(required = false) Integer duration) {
		return eventServices.updateEvent(idEvent, title, theme, description, location, maxCapacity, day, month, year,
				hour, minute, organizer, status, duration);
	}

	@GetMapping("/allByOrganizer")
	public List<Event> getEventByOrganizer(@RequestParam Integer afm) {
		return eventServices.getEventsByOrganizer(afm);
	}

	@PutMapping("/deleteByEmployee")
	public List<Event> deleteByEmployee(@RequestParam Integer employeeId, @RequestParam Integer evenetId) {
		return eventServices.deleteEventByEmployee(employeeId, evenetId);
	}

}
