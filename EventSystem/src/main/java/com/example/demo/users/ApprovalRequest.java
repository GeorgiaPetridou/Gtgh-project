package com.example.demo.users;

import java.util.Scanner;

public class ApprovalRequest {
	//private String type; 
	private Integer Id;
	private Event theEvent;
	private String type; //add or delete
	private Organizer SubmittedById; //AFM of the organizer that made the request
	private String createdAt; //date that the request was created
	private String status; // approved or rejected (request)
	private Employee handledById; //ID of the employee that processes it
	private String closedAt; //date that the request was processed
	private String comments;
	
	//request is created on the event constractor   
	public ApprovalRequest(Event theEvent, Organizer submittedBy, String createdAt, String status) {
		//this.type = type;
		this.theEvent = theEvent;
		this.SubmittedById = submittedBy;
		this.createdAt = createdAt;
		this.status = status;		
	}
	
	public Event getTheEvent() {
		return theEvent;
	}
	public void setTheEvent(Event theEvent) {
		this.theEvent = theEvent;
	}
	public Organizer getSubmittedBy() {
		return SubmittedById;
	}
	public void setSubmittedBy(Organizer submittedBy) {
		SubmittedById = submittedBy;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Employee getHandledBy() {
		return handledById;
	}
	public void setHandledBy(Employee handledBy) {
		this.handledById = handledBy;
	}
	public String getClosedAt() {
		return closedAt;
	}
	public void setClosedAt(Integer day, String month, Integer year) {
		this.closedAt = day+" "+month+" "+year;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	
	
}
