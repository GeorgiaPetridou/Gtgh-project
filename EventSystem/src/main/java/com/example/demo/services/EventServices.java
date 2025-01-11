package com.example.demo.services;


import java.io.IOException;
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
	private static List<Event> events= new ArrayList<Event>();
	private static Path filePath = Path.of("events.txt");
	
	//Add Event
	
	public List<Event> addEvent(Event e){
		events.add(e);
		return events;
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
	
	//Remove Event (when Organizer applies for it)
	
	public List<Event> applyForRemoveEvent(Integer id){
		for(Event e: events) {
			if(e.getId() == id) {
				e.setStatus("ToBeDeleted");
			
			}
		}
		return events;
	}
	//Remove Event (Organizer Accepts Deletion)
	public List<Event> approveRemoveEvent(Integer id){
		for(Event e: events) {
			if(e.getId() == id) {
				e.setStatus("Deleted");
				
			}
		}
		return events;
	}
	//Organizer approves event to be added
	
	public List<Event> approvedEvent(Integer id){
		for(Event e : events) {
			if(e.getId() == id) {
				e.setStatus("Approved");
				
			}
		}
		return events;
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
