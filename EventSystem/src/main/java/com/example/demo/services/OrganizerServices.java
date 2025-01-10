package com.example.demo.services;

import java.time.LocalDate;

import com.example.demo.users.ApprovalRequest;
import com.example.demo.users.Event;

public class OrganizerServices {


	//add a new event and put it in the list with the not approved events 
	public void addEvent(String title, String theme, String description, String location, int maxCapacity,int day,
			String month, int year, int hour, int minute) {
		Event newEvent = new Event(title,theme,description,location,maxCapacity,day,month,year,hour,minute,this);
		EventServices.addToList(newEvent);
		
		//EventsDb.showListOfEvents();
		
		
		
	}
	//looks for an event with the specific title this organizer had previously added in the list and then it gets deleted and put in the list with the deleted events
	public void deleteEvent(String title) {
		for(Event e :EventServices.getListOfEvents()) {
			if(title.equals(e.getTitle()) && e.getOrganizer() == this && !(e.getStatus().equals("approved"))) {
				e.setStatus("TBD");
				ApprovalRequest req = new ApprovalRequest(e, this, LocalDate.now(), "TBD" );
				e.setReqTBD(req);
			}
			
		}
		//EventsDb.showListOfEvents();
		
	}
	//Shows the list of events the specific organizer has made 
	public void showList() {
		for(Event e : EventServices.getListOfEvents()) {
			if(e.getOrganizer()== this) {
				System.out.println(e);
			}
		}
	}
	
	
}