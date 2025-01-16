package com.example.demo.users;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	
	
	private Integer Id;
	private String name;
	private String surname;
	private String email;
	private List<Event> deletedByEmployee = new ArrayList<Event>();
	
	//Constractor
	public Employee(String name, String surname, String email) {
		
		this.name = name;
		this.surname = surname;
		this.email = email;
		
	}
	
	
	//Getters and Setters
	
	
	public Integer getId() {
		return Id;
	}
	public void setId(int iD) {
		Id = iD;
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
	
	
	
	public List<Event> getDeletedByEmployee() {
		return deletedByEmployee;
	}


	public void setDeletedByEmployee(List<Event> deletedByEmployee) {
		this.deletedByEmployee = deletedByEmployee;
	}





	@Override
	public String toString() {
		return "Employee [ID=" + Id + ", name=" + name + ", surname=" + surname + "]";
	}
	
	
}












