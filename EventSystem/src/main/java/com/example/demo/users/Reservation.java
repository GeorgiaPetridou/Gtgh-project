package com.example.demo.users;

public class Reservation {

	private Integer ID;
	private Visitor visitor;
	private Event event;

	public Reservation(Visitor visitor,Event event, Integer ID) {
		
		this.ID = ID;
		this.event = event;
		this.visitor = visitor;
		
		
	}
	
	

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
	public String toString(){
		return "Reservation [visitor: " + visitor.getName() + visitor.getSurname() + ",event: " + event.getTitle() + ",status "
				+ "]";
				
	}
	
	
}

