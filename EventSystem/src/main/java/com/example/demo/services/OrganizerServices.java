package com.example.demo.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.users.ApprovalRequest;
import com.example.demo.users.Event;
import com.example.demo.users.Organizer;

import com.example.demo.users.ApprovalRequest;
import com.example.demo.users.Event;

public class OrganizerServices {

	List<Organizer> organizers = new ArrayList<Organizer>();

    //add organizer
    public List<Organizer> addOrganizer(Organizer o){
        organizers.add(o);
        return organizers;
    }





    //removeOrganizer 
    public List<Organizer> removeOrganizer(Integer afm){
        organizers.removeIf(organizer -> organizer.getAfm().equals(afm));
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
                return organizers;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Organizer with afm " + afm + " doesnt exist");
    }


}