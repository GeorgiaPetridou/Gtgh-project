package com.example.demo.users;

public class Reservation {

	private Visitor visitor;
	private Event event;

	public Reservation(Visitor visitor,Event event) {
		
		this.event = event;
		this.visitor = visitor;
		
		
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

