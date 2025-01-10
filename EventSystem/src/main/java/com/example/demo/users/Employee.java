package com.example.demo.users;


public class Employee {
	
	private static int counter = 0; 
	private int ID;
	private String name;
	private String surname;
	private String email;
	
	//Constractor
	public Employee(String name, String surname, String email) {
		this.ID = counter++;
		this.name = name;
		this.surname = surname;
		this.email = email;
	}
	
	
	//Getters and Setters
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
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
		return "Employee [ID=" + ID + ", name=" + name + ", surname=" + surname + "]";
	}
	
	
}












