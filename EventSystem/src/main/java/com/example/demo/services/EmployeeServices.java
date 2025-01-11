package com.example.demo.services;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.example.demo.users.Event;

public class EmployeeServices {
//
//	//employee views whole list unfiltered
//		public List<Event> employeeViewsList() {
//			List<Event> AllEvents = EventServices.getListOfEvents();
//			
//			AllEvents.stream().forEach(System.out::println);
//			
//			return AllEvents;
//		}
//		
//		//employee views filtered list based on the filter they choose
//		public List<Event> employeeViewsList(String filter) {
//			/*String filter;
//			if (anyfilter.equalsIgnoreCase("to be deleted")) {
//				filter = "TBD";
//			}
//			else if(anyfilter.equalsIgnoreCase("to be approved")){
//				filter = "TBA";
//			}
//			else if(anyfilter.equalsIgnoreCase("approved")){
//				filter = "approved";
//			}
//			else if(anyfilter.equalsIgnoreCase("denied")){
//				filter = "denied";
//			}
//			else {
//				filter = "deleted";
//			}*/
//			List<Event> filteredEvents = EventServices.getListOfEvents().stream()
//	              .filter(event -> filter.equals(event.getStatus()))
//	              .collect(Collectors.toList());
//			System.out.println("Filtered Events:");
//	      //filteredEvents.forEach(System.out::println);
//			IntStream.range(0, filteredEvents.size())
//	      .forEach(i -> System.out.println((i + 1) + ". " + filteredEvents.get(i)));
//	      return filteredEvents;
//		}
//		
//		//it's called by an Employee who's making choices on the run
//		public void employeeProcessesRequest() {
//			System.out.println("select type of requests you wish to process (TO BE APPROVED or TO BE DELETED");
//			Scanner scanner = new Scanner(System.in);
//			String filter = scanner.nextLine();
//			//handle exceptions
//			List<Event> filteredEvents = employeeViewsList(filter);
//			
//			System.out.println("select the number of the event you want to process");
//			String eTitle = scanner.nextLine();
//			//handle exceptions
//			/*if (filteredEvents.size() < ind) { 
//	          System.out.println("No event found at this counter in the filtered list.");
//	          System.out.println("please pick again.");
//	      }*/
//			String TBP = (filter.equalsIgnoreCase("TBA")) ? "To Be Approved" : "To Be Deleted";
//			Event selectedEvent;
//			for(Event e :EventServices.getListOfEvents()) {
//				if(eTitle.equals(e.getTitle())) {
//					selectedEvent = e;
//				}	
//			}
//	      System.out.println("the event you selected is: " + selectedEvent);
//	      System.out.println("Do you approve this event " + TBP + " ?"); // TO BE DELETED or TO BE APPROVED
//	      String answer = scanner.nextLine();
//	      //handle exceptions
//	      //at this point employee can cancel process with "cancel" or "exit"
//	      if (answer.equalsIgnoreCase("YES")) {
//	      	if (filter.equalsIgnoreCase("TBA")) {
//	      		selectedEvent.setStatus("approved"); 
//	              System.out.println("Event: " + selectedEvent + " is successfully approved");
//	              //send message to organizer
//	              //selectedEvent.getReqTBA().updateApprovalRequest(this, "-");
//	      	}
//	      	else {
//	      		selectedEvent.setStatus("deleted"); 
//	              System.out.println("Event: " + selectedEvent + " is successfully deleted");
//	              //send message to organizer
//	            //  selectedEvent.getReqTBD().updateApprovalRequest(this, "-");
//	      	}    
//	      }else {
//	      	if (filter.equalsIgnoreCase("TBA")){
//	      		selectedEvent.setStatus("denied");
//	      		System.out.println("Event: " + selectedEvent + " was rejected the approval");
//	      	}
//	      	else {
//	      		System.out.println("Event: " + selectedEvent + " was rejected the deletion");
//	      	}
//	      	System.out.println("Please make a comment for the reason you rejected the request: ");
//	      	String comment = scanner.nextLine();
//	          //send message to organizer
//	          selectedEvent.getReqTBA().updateApprovalRequest(this, comment);
//	      }
//	      
//			
//	      scanner.close();
//		}
//	
	
	
	
}
