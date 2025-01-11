package com.example.demo.users;

public class Visitor {

	//Properties
	private int counter =0;
	private Integer id;
	private String name;
	private String surname;
	private String email;


	//Constructor
	public Visitor(String name,String surname,String email) {
		
		this.name = name;
		this.surname = surname ;
		this.email = email ;
	}
	
	
	//Getters and Setters
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
	public String toString(){
		return "Visitor: " + name + surname + email;
				
	}
	
}