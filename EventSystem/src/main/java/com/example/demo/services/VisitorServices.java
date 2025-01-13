package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.users.Visitor;

@Service
public class VisitorServices {

	//Constructor
	private List<Visitor> visitors = new ArrayList<Visitor>();
	
	
	//Getters and Setters
	public List<Visitor> getAllVisitors() {
		return visitors;
	}

	public void setVisitors(List<Visitor> visitors) {
		this.visitors = visitors;
	}


	
	//Methods
	
	
	//Remove visitor from the list
	public List<Visitor> removeVisitor(Integer ID) {
		visitors.removeIf(visitor -> visitor.getID().equals(ID));
		return visitors;
	}
	
	
	//Add visitor to the list
	public List<Visitor> addVisitor(Visitor visitor) {
		visitors.add(visitor);
		return visitors;
	}
	
	
	//Update visitor's informations
	public List<Visitor> updateVisitor(String newName,String newSurname,String email) {
		for (Visitor visitor : visitors) {
			if(visitor.getEmail().equals(email)) {
				if(newName !=null) 
					visitor.setName(newName); 
				
				if(newSurname !=null) 
					visitor.setSurname(newSurname); 
			}
		}
		return visitors;
	
	}

	
	
	
}
