package com.example.demo.users;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Organizer {
	private Integer afm;
	private String name;
	private String surname;
	private String description;
	@JsonIgnore
	private List<Event> orgsEvents = new ArrayList<>();

	// Constructor
	public Organizer(Integer afm, String name, String surname, String description) {
		this.afm = afm;
		this.name = name;
		this.surname = surname;
		this.description = description;
	}

	// Getters + Setters
	public Integer getAfm() {
		return afm;
	}

	public void setAfm(int afm) {
		this.afm = afm;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Event> getEvents() {
		return orgsEvents;
	}

	public void setEvents(List<Event> events) {
		this.orgsEvents = events;
	}

	// ToString
	@Override
	public String toString() {
		return "Organizer [afm=" + afm + ", name=" + name + ", surname=" + surname + ", description=" + description
				+ "]";
	}

}
