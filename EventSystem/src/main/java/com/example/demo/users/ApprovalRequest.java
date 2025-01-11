package com.example.demo.users;

import java.util.Scanner;

public class ApprovalRequest {
	//private String type; 
	private Integer Id;
	private Integer EventId;
	private String type; //add or delete
	private Integer SubmittedById; //AFM of the organizer that made the request
	private String createdAt; //date that the request was created
	private String status; // approved or rejected (request)
	private Integer handledById; //ID of the employee that processes it
	private String closedAt; //date that the request was processed
	private String comments;
	
	//request is created on the event constractor   
	public ApprovalRequest(Integer theEvent, Integer submittedBy, String createdAt, String status) {
		//this.type = type;
		this.EventId = theEvent;
		this.SubmittedById = submittedBy;
		this.createdAt = createdAt;
		this.status = status;		
	}
	
	public Integer getTheEvent() {
		return EventId;
	}
	public void setTheEvent(Integer theEvent) {
		this.EventId = EventId;
	}
	public Integer getSubmittedBy() {
		return SubmittedById;
	}
	public void setSubmittedBy(Integer submittedBy) {
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
	public Integer getHandledBy() {
		return handledById;
	}
	public void setHandledBy(Integer handledBy) {
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
