package com.example.demo.services;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.example.demo.users.ApprovalRequest;
import com.example.demo.users.Event;
import com.example.demo.users.Organizer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


import com.example.demo.users.Event;
import com.example.demo.users.Organizer;


@Service
public class EventServices {

	private  List<Event> events= new ArrayList<Event>();

	@Autowired
	OrganizerServices organizerServices;
	ApprovalRequestServices approvalRequestServices;
	

	private Integer UniqVisitorID() {
        return events.stream()
                .mapToInt(Event::getId) 
                .max() 
                .orElse(0) + 1; 
    }
	

	public List<Event> addEvent(Event e,Integer afm){
		if(events.contains(e) ) {
			return events;
		}
		else {
			for(Organizer o: organizerServices.getAllOrganizers()) {
				if(o.getAfm().equals(afm)) {
					e.setId(UniqVisitorID());
					e.setOrganizer(o);	
					events.add(e);
					//approval request
					return events;
				}
			}
		}
		return events;
	}
	
	
	

	public List<Event> addEvent(Event e , Integer afm ,ApprovalRequest aRequest){
		 if(events.contains(e))
	            return events;
	        else {
	        	for(Organizer o: organizerServices.getAllOrganizers()) {
					if(o.getAfm().equals(afm)) {
						e.setId(UniqVisitorID());
						e.setOrganizer(o);	
						events.add(e);
						approvalRequestServices.addApprovalRequest(aRequest);
						return events;
					}
				}
	        }
		 return events;
	}

	//Remove Event
	public List<Event> removeEvent(Integer id){
		for(Event e: events) {
			if(e.getId().equals(id)) {
				events.remove(e);
				
			}
		}
		return events;
	}
	
	//Organizer applies for Event to be deleted
	public List<Event> applyToDeleteEvent(Integer id){
		for(Event e: events) {
			if(e.getId() == id) {
				e.setStatus("ToBeDeleted");
				//create approval request 
				ApprovalRequest request = new ApprovalRequest(e, e.getOrganizer(), "delete");
				approvalRequestServices.addApprovalRequest(request);
			}
		}
		return events;
	}

	//Employee Approves Addition of Event	
		public List<Event> approveEvent(Integer id){
			for(Event e : events) {
				if(e.getId() == id) {
					e.setStatus("Approved");
					
				}
			}
			return events;
		}	
	
	//Employee rejects request for addition -> denies Event
	public List<Event> denyEvent(Integer id){
		for(Event e:events) {
			if(e.getId().equals(id)) {
				e.setStatus("Denied");
			}
		}
		return events;
	}
	

	public List<Event> deleteEvent(Integer id){
		for(Event e: events) {
			if(e.getId().equals(id)) {
				e.setStatus("Deleted");
				
			}
		}
		return events;
	}
	

	public List<Event> approvedEvent(Integer id){
		for(Event e : events) {
			if(e.getId().equals(id)) {
				e.setStatus("Approved");
			}
		}
			return events;
	}

	//when Employee rejects request for deletion -> the event.status remains unchanged
	
	//Employee Deletes an Event wihtout a request
	public List<Event> deleteEventWithoutRequest(Integer id, Integer employeeId){
		for(Event e: events) {
			if(e.getId() == id) {
				e.setStatus("Deleted");
				//create approval request 
				//put the organizer = null, type = "delete"
				ApprovalRequest request = new ApprovalRequest(e, null, "delete");
				approvalRequestServices.addApprovalRequest(request);
				approvalRequestServices.approveRequest(id, employeeId, null);

			}
		}
		return events;
	}

	//Search With Stream
	public List<Event> searchEvents( String theme,  String location,  Integer day,
			String month, Integer year){
		return events.stream().filter(event -> location == null || event.getLocation().equals(location)).filter(event -> theme == null || event.getTheme().equals(theme)).
				filter(event -> (day==null && month == null && year == null ) ||( event.getDay()==day && event.getMonth().equals(month) && event.getYear()==year  )).collect(Collectors.toList());
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
		}
		return events;
	}
	//Add a visitor to the event
	public List<Event> addToCountVisitors(Integer eventID) {
	    for (Event event : getAllEvents()) {
	        if (event.getId().equals(eventID)) {
	            if (event.getCountVisitors() < event.getMaxCapacity()) {
	                event.setCountVisitors(event.getCountVisitors() + 1);
	          }
	        }
	    }return events;
	 }
	
	
	
	
		//remove a visitor from the event
	public List<Event> reduceToCountVisitors(Integer id) {
		for(Event e : events) {
			if(e.getId()==id) {
				Integer count = e.getCountVisitors();
				count--;
				e.setCountVisitors(count);
			}
		}
		return events;
	}
	
	
	

		
	
	
}



