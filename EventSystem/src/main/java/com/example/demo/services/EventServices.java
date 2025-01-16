package com.example.demo.services;


import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.users.Employee;
import com.example.demo.users.Event;
import com.example.demo.users.Organizer;


@Service
public class EventServices {
	private  List<Event> events= new ArrayList<Event>();
	
	@Autowired
	OrganizerServices organizerServices;
//	@Autowired
	ReservationServices reservationServices;
	@Autowired
	EmployeeServices employeeServices;

	//id generator
	private Integer UniqEventID() {
        return events.stream()
                .mapToInt(Event::getId) 
                .max() 
                .orElse(0) + 1; 
    }

	public void addEvent(Event e,Organizer o) {
		if(events.contains(e) ) {
			return;
		}
		else {
			e.setId(UniqEventID());
			e.setOrganizer(o);	
			events.add(e);
		}
		 
		
	}

	
	
	//Remove Event
	public List<Event> removeEvent(Integer id){
		for(Event e: events) {
			if(e.getId().equals(id)) {
				events.remove(e);
				return events;
			}
		}
		return events;
		//throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event with id " + id + " doesnt exist");
	}
	
	//Denied Event
	
	public void denyEvent(Integer id){
		for(Event e:events) {
			if(e.getId().equals(id)) {
				e.setStatus("Denied");
			}
		}
		//throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event with id " + id + " doesnt exist");
	}
	
	//Organizer applies for Event to be deleted
	
	public void applyToDeleteEvent(Integer id){
		for(Event e: events) {
			if(e.getId().equals(id)) {
				e.setStatus("ToBeDeleted");
				return;
			}
			
		}
	}
	//Employee Deletes an Event (either approves deletion or deletes themselves)
	public void deleteEvent(Integer id){
		for(Event e: events) {
			if(e.getId().equals(id)) {
				e.setStatus("Deleted");
				//reservationServices.removeAllReservationsForSpecificEvent(id);
			}
		}
	}
	
	public List<Event> deleteEventByEmployee(Integer employeeId, Integer eventId) {
		
		for (Employee emp: employeeServices.getAllEmployees()) {
			if(emp.getId().equals(employeeId)) {
				this.deleteEvent(eventId);
				for(Event e:events) {
					if(e.getId().equals(eventId)) {
						employeeServices.addDeletedEvent(e, employeeId);
					}
				}
			}
		}
		return events;
	}
	
	//Employee Approves Addition of Event
	
	public void approveEvent(Integer id){
		for(Event e : events) {
			if(e.getId().equals(id)) {
				e.setStatus("Approved");
				
			}
		}
		//throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event with id " + id + " doesnt exist");
		
	}
	
	
	//Search With Stream
	public List<Event> searchEvents( String theme,  String location,  Integer day,
			String month, Integer year){
		return events.stream().filter(event -> location == null || event.getLocation().equals(location)).filter(event -> theme == null || event.getTheme().equals(theme)).
				filter(event -> (day==null && month == null && year == null ) ||( event.getDay().equals(day) && event.getMonth().equals(month) && event.getYear().equals(year)  )).collect(Collectors.toList());
	}
	
	//getAll
	
	public List<Event> getAllEvents(){
		return events;
	}
	
	//update Event
	
	public List<Event> updateEvent(Integer idEvent,String title, String theme, String description, String location, Integer maxCapacity, Integer day,
			String month, Integer year, Integer hour, Integer minute,Organizer organizer, String  status){
		
		for(Event e: events) {
			if(e.getId().equals(idEvent) ) {
				if(title != null) {
					e.setTitle(title);
				}
				if(theme != null) {
					e.setTheme(theme);
				}
				if(description != null) {
					e.setDescription(description);
				}
				if(location != null) {
					e.setLocation(location);
				}
				if(maxCapacity != null) {
					e.setMaxCapacity(maxCapacity);
				}
				if(day != null) {
					e.setDay(day);
				}
				if(month != null) {
					e.setMonth(month);
				}
				if(year != null) {
					e.setYear(year);
				}
				if(hour != null) {
					e.setHour(hour);
				}
				if(minute != null) {
					e.setMinute(minute);
				}
				if(organizer != null) {
					e.setOrganizer(organizer);
				}
				if(status != null) {
					e.setStatus(status);
				}
				
			}
			//throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event with id " + idEvent + " doesnt exist");
		
		}
		return events;
		
	}

	
	public List<Event> getEventsByOrganizer(Integer afm){
		return events.stream().filter(event -> event.getOrganizer().getAfm().equals(afm)).collect(Collectors.toList());
		
	}
	
	

		
	
	
}
