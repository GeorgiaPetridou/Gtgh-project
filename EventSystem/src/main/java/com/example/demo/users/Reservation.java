package com.example.demo.users;

public class Reservation {

	// Properties
	private Integer ID;
	private Visitor visitor;
	private Event event;

	// Constructor
	public Reservation(Visitor visitor, Event event, Integer ID) {

		this.ID = ID;
		this.event = event;
		this.visitor = visitor;

	}

	// Getters and Setters

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Visitor getVisitor() {
		return visitor;
	}

	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "Reservation [Visitor: " + visitor.getName() + visitor.getSurname() + ",Event: " + event.getTitle()
				+ ",Status " + "]";

	}

}
