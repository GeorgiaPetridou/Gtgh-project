package com.example.demo.services;

import java.util.ArrayList;

import java.util.List;


import org.springframework.stereotype.Service;


import com.example.demo.users.Organizer;

@Service
public class OrganizerServices {

	List<Organizer> organizers = new ArrayList<Organizer>();

	// add organizer
	public List<Organizer> addOrganizer(Organizer o) {
		for (Organizer organizer : organizers) {
			if (organizer.getAfm().equals(o.getAfm())) {
				System.out.println("Organizer with afm " + o.getAfm() + " already exists.");
				return organizers;
			}
		}

		organizers.add(o);
		System.out.println("Organizer added: " + o);
		return organizers;
	}

	// removeOrganizer
	public List<Organizer> removeOrganizer(Integer afm) {
		organizers.removeIf(organizer -> organizer.getAfm().equals(afm));
		return organizers;
	}

	// getAllOrganizers
	public List<Organizer> getAllOrganizers() {
		return organizers;
	}

	// Update
	public List<Organizer> updateOrganizer(Integer afm, String name, String surname, String description) {
		for (Organizer o : organizers) {
			if (o.getAfm().equals(afm)) {
				if (name != null) {
					o.setName(name);
				}
				if (surname != null) {
					o.setSurname(surname);
				}
				if (description != null) {
					o.setDescription(description);

				}
				return organizers;
			}
		}
		return organizers;
	}

}