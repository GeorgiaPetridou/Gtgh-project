package com.example.demo.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.users.ApprovalRequest;
import com.example.demo.users.Event;
import com.example.demo.users.Organizer;

@Service
public class OrganizerServices {

	List<Organizer> organizers = new ArrayList<Organizer>();
	
	//add organizer
	public List<Organizer> addOrganizer(Organizer o){
		organizers.add(o);
		return organizers;
	}
	
		
		
		
	
	//removeOrganizer 
	public List<Organizer> removeOrganizer(Integer afm){
		for(Organizer o : organizers) {
			if(o.getAfm() == afm) {
				organizers.remove(o);
				return organizers;
			}
		}
		return organizers;
	}
		
	
	//getAllOrganizers
	public List<Organizer> getAllOrganizers(){
		return organizers;
	}
		
	
	//Update
	public List<Organizer> updateOrganizer(Integer afm ,String name,String surname , String description ){
		for(Organizer o : organizers) {
			if(o.getAfm() == afm) {
				if(name != null) {
					o.setName(name);
				}
				if(surname != null) {
					o.setSurname(surname);
				}
				if(description != null) {
					o.setDescription(description);
				}
			}
		}
		return organizers;
	}
	
	
}