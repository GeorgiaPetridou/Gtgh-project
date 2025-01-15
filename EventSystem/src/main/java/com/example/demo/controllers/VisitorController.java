package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.ReservationService;
import com.example.demo.services.ReservationServices;
import com.example.demo.services.VisitorServices;
import com.example.demo.users.Visitor;

@RestController
@RequestMapping("/visitors") 
public class VisitorController {
	
	@Autowired
	private VisitorServices visitorServices;
	

    @Autowired
    private ReservationServices reservationServices;
	

	@GetMapping("/allvisitors")
	public List<Visitor> getAllVisitors(){
		return visitorServices.getAllVisitors();	
	}
	
	

	@PostMapping("/add")
	public Visitor addVisitor(@RequestBody Visitor visitor){
		return visitorServices.addVisitor(visitor);
	}
	
	@DeleteMapping("/delete")
	public List<Visitor> removeVisitor(@RequestParam Integer ID){
		return visitorServices.removeVisitor(ID);
	}
	
	@PutMapping("/update")
	public List<Visitor> updateVisitor(@RequestParam Integer ID,@RequestParam (required = false) String newName, 
			@RequestParam (required = false) String newSurname,@RequestParam (required = false) String email){
		return visitorServices.updateVisitor(ID,newName, newSurname, email );
	}
	
	
	
}
