package com.example.demo.services;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

public class EventServices {
private  List<Event> events= new ArrayList<Event>();
	
	
	//Add Event
	
	public List<Event> addEvent(Event e /* No arguments for approval req*/){
		 if(events.contains(e))
	            return events;
	        else {
	            //check if organizer exists
	            events.add(e);
	            //create approval request
	            //addApprovalRequest(e,e.getOrganizer(),"tobeadded");
	            
	            return events;
	        }
	}
	//Remove Event
	public List<Event> removeEvent(Integer id){
		for(Event e: events) {
			if(e.getId() == id) {
				events.remove(e);
				
			}
		}
		return events;
	}
	
	//Denied Event
	
	public List<Event> denyEvent(Integer id){
		for(Event e:events) {
			if(e.getId() == id) {
				e.setStatus("Denied");
			}
		}
		return events;
	}
	
	//Organizer applies for Event to be deleted
	
	public List<Event> applyToDeleteEvent(Integer id){
		for(Event e: events) {
			if(e.getId() == id) {
				e.setStatus("ToBeDeleted");
			
			}
		}
		return events;
	}
	//Employee Deletes an Event (either approves deletion or deletes themselves)
	public List<Event> deleteEvent(Integer id){
		for(Event e: events) {
			if(e.getId() == id) {
				e.setStatus("Deleted");
				
			}
		}
		return events;
	}
	//Employee Approves Addition of Event
	
	public List<Event> approvedEvent(Integer id){
		for(Event e : events) {
			if(e.getId() == id) {
				e.setStatus("Approved");
				
			}
		}
		return events;
	}
	
	
	//Search With Stream
	public List<Event> searchEvents( String theme,  String location,  Integer day,
			String month, Integer year, Integer hour, Integer minute){
		return events.stream().filter(event -> location == null || event.getLocation().equals(location)).filter(event -> theme == null || event.getTheme().equals(theme)).
				filter(event -> (day==null && month == null && year == null && hour==null && minute == null) ||( event.getDay()==day && event.getMonth().equals(month) && event.getYear()==year && event.getHour()==hour && event.getMinute()==minute )).collect(Collectors.toList());
	}
	
	//getAll
	
	public List<Event> getAllEvents(){
		return events;
	}
	
	//update Event
	
	public List<Event> updateEvent(Integer idEvent,String title, String theme, String description, String location, Integer maxCapacity, Integer day,
			String month, Integer year, Integer hour, Integer minute,Organizer organizer, String  status){
		
		for(Event e: events) {
			if(e.getId() == idEvent ) {
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
	
	
	
	
//
//	//Adds an event to the listOfEvents with status notApprovedAdded
//	public static void addToList(Event e) {
//		listOfEvents.add(e);
//	}
//	//When you delete an event it actually changes the events status from approved or notApprovedAdded to notApprovedDeleted
//	public static void deleteFromEvent(Event e) {
//		e.setStatus("toBeDeleted");
//	}
//	//Print of the list Of Events
//	public static void showListOfEvents() {
//		System.out.println(listOfEvents);	
//	}
//	
//	
//	
//	//print  the events that are added but not approved
//	public static void printEventsToBeAdded() {
//		//Print on the console
//		listOfEvents.stream().filter(e -> e.getStatus().equals("toBeAdded")).forEach(System.out::println);
//		
//		//To print in a file: transform the arraylist to a string 
//		String content = listOfEvents.stream().filter(e -> e.getStatus().equals("toBeAdded")).map(Event::toString).collect(Collectors.joining("\n"));
//		 //write the string form of the events list to the txt file
//         try {
//			Files.writeString(filePath, content);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	
//	//print the events that are deleted but not approved
//		public static void printEventsToBeDeleted() {
//			//Print on the console
//			listOfEvents.stream().filter(e -> e.getStatus().equals("toBeDeleted")).forEach(System.out::println);
//			
//			//To print in a file: transform the arraylist to a string 
//			String content = listOfEvents.stream().filter(e -> e.getStatus().equals("toBeDeleted")).map(Event::toString).collect(Collectors.joining("\n"));
//			
//			 //write the string form of the events list to the txt file
//	         try {
//				Files.writeString(filePath, content);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		
//		
//		//Print the events that are deleted and approved
//		public static void printEventsApprovedDeleted() {
//			//Print on the console
//			listOfEvents.stream().filter(e -> e.getStatus().equals("deleted")).forEach(System.out::println);
//			
//			//To print in a file: transform the arraylist to a string 
//			String content = listOfEvents.stream().filter(e -> e.getStatus().equals("deleted")).map(Event::toString).collect(Collectors.joining("\n"));
//			 //write the string form of the events list to the txt file
//	         try {
//				Files.writeString(filePath, content);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		//print  the events that are added and approved
//		public static void printEventsApprovedAdded() {
//			//Print on the console
//			listOfEvents.stream().filter(e -> e.getStatus().equals("added")).forEach(System.out::println);
//			
//			//To print in a file: transform the arraylist to a string 
//			String content = listOfEvents.stream().filter(e -> e.getStatus().equals("added")).map(Event::toString).collect(Collectors.joining("\n"));
//			 //write the string form of the events list to the txt file
//	         try {
//				Files.writeString(filePath, content);
//				
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		
//		
//	//Print in a file the events for each organizer
//	public static void print() {
//		//Sort the events based on their organizer
//		Map<Organizer, List<Event>> groupByOrganizer = listOfEvents.stream()
//                .sorted((e1, e2) -> e1.getOrganizer().getName().compareTo(e2.getOrganizer().getName())) //Sort the events by their organizer
//                .collect(Collectors.groupingBy(event -> event.getOrganizer()));//group the events by their organizer
//		
//		//Print the events on the console
//		groupByOrganizer.forEach((organizer,listOfEvents) -> {
//	            System.out.println("Organizer: " + organizer.getName()+ " " +organizer.getAfm());
//	            listOfEvents.forEach(event -> System.out.println("  " + event));
//	        });
//		
//		//Print the events in the file
//		
//		
}
