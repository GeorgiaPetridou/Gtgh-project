package com.example.demo.controllers;

import java.util.List;
<<<<<<< HEAD

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.EventServices;
import com.example.demo.users.Event;
import com.example.demo.users.Organizer;





@RestController
@RequestMapping("events")
public class EventController {

=======

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.services.EventServices;
import com.example.demo.users.ApprovalRequest;
import com.example.demo.users.Event;
import com.example.demo.users.Organizer;

public class EventController {
>>>>>>> gina2
	@Autowired
	 EventServices eventServices;
	
	@PostMapping("/add")
<<<<<<< HEAD
	public List<Event> addEvent(@RequestBody Event e ,@RequestParam Integer afm){
		return eventServices.addEvent(e,afm);
=======
	public List<Event> addEvent(@RequestBody Event e ,@RequestParam Integer afm,@RequestBody ApprovalRequest aRequest){
		return eventServices.addEvent(e,afm,aRequest);
>>>>>>> gina2
	}
	
	@DeleteMapping("/remove")
	public List<Event> removeEvent(@RequestParam Integer id){
		return eventServices.removeEvent(id);
	}
	
	@PutMapping("/deny")
	public List<Event> denyEvent(@RequestParam Integer id){
		return eventServices.denyEvent(id);
	}
	
	@PutMapping("/applyToDelete")
	public List<Event> applyToDelete(@RequestParam Integer id){
		return eventServices.applyToDeleteEvent(id);
	}
	
	@PutMapping("/delete")
	public List<Event> deleteEvent(@RequestParam  Integer id){
		return eventServices.deleteEvent(id);
	}
	
	@PutMapping("/approve")
	public List<Event> approveToAddEvent(@RequestParam Integer id){
<<<<<<< HEAD
		return eventServices.approvedEvent(id);
=======
		return eventServices.approveEvent(id);
>>>>>>> gina2
	}
	
	@GetMapping("/search")
	public List<Event> searchEvent( @RequestParam(required = false)String theme,@RequestParam(required = false)  String location,@RequestParam(required = false)  Integer day,
<<<<<<< HEAD
			@RequestParam(required = false) String month,@RequestParam(required = false) Integer year){
		return eventServices.searchEvents(theme, location, day, month, year);
=======
			@RequestParam(required = false) String month,@RequestParam(required = false) Integer year, @RequestParam(required = false) Integer hour, @RequestParam(required = false) Integer minute){
		return eventServices.searchEvents(theme, location, day, month, year, hour, minute);
>>>>>>> gina2
	}
	
	@GetMapping("/all")
	public List<Event> getAllEvents(){
		return eventServices.getAllEvents();
	}
	
	
	@PutMapping("/update")
	public List<Event> updateEvent(@RequestParam Integer idEvent,@RequestParam(required = false) String title,@RequestParam(required = false) String theme,@RequestParam(required = false) String description,@RequestParam(required = false) String location,@RequestParam(required = false) Integer maxCapacity,@RequestParam(required = false) Integer day,
			@RequestParam(required = false) String month,@RequestParam(required = false) Integer year,@RequestParam(required = false) Integer hour,@RequestParam(required = false) Integer minute,@RequestParam(required = false) Organizer organizer,@RequestParam(required = false) String  status)
	{
		return eventServices.updateEvent(idEvent, title, theme, description, location, maxCapacity, day, month, year, hour, minute, organizer, status);
	}
	
	@PutMapping("/addVisitor")
	public List<Event> addVisitor(@RequestParam Integer id){
		return eventServices.addToCountVisitors(id);
	}
	@PutMapping("/removeVisitor")
	public List<Event> removeVisitor(@RequestParam Integer id){
		return eventServices.reduceToCountVisitors(id);
	}
<<<<<<< HEAD
	
	
	
=======
>>>>>>> gina2
}
