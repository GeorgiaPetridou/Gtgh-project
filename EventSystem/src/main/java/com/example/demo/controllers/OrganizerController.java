package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.OrganizerServices;
import com.example.demo.users.Event;
import com.example.demo.users.Organizer;

@RestController
@RequestMapping("organizers")
public class OrganizerController {
	@Autowired
	OrganizerServices organizerServices;

	@PostMapping("/add")
	public List<Organizer> addOrganizer(@RequestBody Organizer o) {
		return organizerServices.addOrganizer(o);
	}

	@GetMapping("/all")
	public List<Organizer> allOrganizers() {
		return organizerServices.getAllOrganizers();
	}

	@DeleteMapping("/remove")
	public List<Organizer> removeOrganizer(@RequestParam Integer afm) {
		return organizerServices.removeOrganizer(afm);
	}

	@PutMapping("/update")
	public List<Organizer> updateOrganizer(@RequestParam Integer afm, @RequestParam(required = false) String name,
			@RequestParam(required = false) String surname, @RequestParam(required = false) String description) {
		return organizerServices.updateOrganizer(afm, name, surname, description);
	}

}
