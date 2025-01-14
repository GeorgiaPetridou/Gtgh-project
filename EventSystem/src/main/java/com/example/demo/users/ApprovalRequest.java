package com.example.demo.users;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ApprovalRequest {
	//private String type; 
	private Integer Id;
	private Event theEvent;
	private String type; //add or delete
	private Organizer SubmittedBy; //AFM of the organizer that made the request
	private LocalDateTime createdAt; //date that the request was created
	private String status; // approved or rejected (request)
	private Employee handledBy; //ID of the employee that processes it
	private LocalDateTime closedAt; //date that the request was processed
	private String comments;
	
	//request is created on the event constractor   
	public ApprovalRequest(Event theEvent, Organizer submittedBy, String type) {
		this.type = type;
		this.theEvent = theEvent;
		this.SubmittedBy = submittedBy;
		this.createdAt = LocalDateTime.now();
		//this.status = null;		
	}
	
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Event getTheEvent() {
		return theEvent;
	}
	public void setTheEvent(Event theEvent) {
		this.theEvent = theEvent;
	}
	public Organizer getSubmittedBy() {
		return SubmittedBy;
	}
	public void setSubmittedBy(Organizer submittedBy) {
		SubmittedBy = submittedBy;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Employee getHandledBy() {
		return handledBy;
	}
	public void setHandledBy(Employee handledBy) {
		this.handledBy = handledBy;
	}
	public LocalDateTime getClosedAt() {
		return closedAt;
	}
	public void setClosedAt(LocalDateTime closedAt) {
		this.closedAt = closedAt;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	
	
}
