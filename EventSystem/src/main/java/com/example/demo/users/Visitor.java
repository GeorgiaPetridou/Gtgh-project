package com.example.demo.users;

public class Visitor {

	// Properties

	private Integer ID;
	private String name;
	private String surname;
	private String email;

	// Constructor
	public Visitor(Integer ID, String name, String surname, String email) {

		this.ID = ID;
		this.name = name;
		this.surname = surname;
		this.email = email;
	}

	// Getters and Setters

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Visitor: " + ID + name + surname + email;

	}

}