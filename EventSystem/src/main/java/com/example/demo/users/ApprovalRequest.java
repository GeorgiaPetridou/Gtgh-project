package com.example.demo.users;

import java.time.LocalDate;
import java.util.Scanner;

public class ApprovalRequest {
	private String type; 
	private Event theEvent;
	private Organizer SubmittedBy; //AFM of the organizer that made the request
	private LocalDate createdAt; //date that the request was created
	private String status; 
	private Employee handledBy; //ID of the employee that processes it
	private LocalDate closedAt; //date that the request was processed
	private String comments;
	
	//request is created on the event constractor   
	public ApprovalRequest(Event theEvent, Organizer submittedBy, LocalDate createdAt) {
		this.type = type;//Add or Delete an event
		this.theEvent = theEvent;
		this.SubmittedBy = submittedBy;
		this.createdAt = createdAt;
			
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
	public LocalDate getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDate createdAt) {
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
	public LocalDate getClosedAt() {
		return closedAt;
	}
	public void setClosedAt(LocalDate closedAt) {
		this.closedAt = closedAt;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	
	
	@Override
	public String toString() {
		return "ApprovalRequest [type=" + type + ", theEvent=" + theEvent + ", SubmittedBy=" + SubmittedBy
				+ ", createdAt=" + createdAt + ", status=" + status + ", handledBy=" + handledBy + ", closedAt="
				+ closedAt + ", comments=" + comments + "]";
	}



	public void updateApprovalRequest(Employee handledBy, String comment) {
		this.setHandledBy(handledBy);
		this.setClosedAt(LocalDate.now());
		this.setComments(comment);
	}
	
}
