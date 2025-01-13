package com.example.demo.services;

import java.util.ArrayList;


import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.example.demo.users.Employee;
import com.example.demo.users.Event;

public class EmployeeServices {

	private List<Employee> employees = new ArrayList<Employee>();	
	
	public List<Employee> getAllEmployees(){
		return employees;
	}
	
	public boolean addEmployee(Employee anEmployee) {
		if (!employees.contains(anEmployee)) {
			employees.add(anEmployee);
			return true;
		}else {
			return false;
		}
	}
	
	public List<Employee> removeEmployee(Integer id) {
		employees.removeIf(employee -> employee.getId().equals(id));
		return employees;
	}
	
	public List<Employee> updateEmployee(Integer id, String newFirstName, String newLastName, String newEmail) {
		for ( Employee employee : employees) {
			if(employee.getId().equals(id)) {
				if (newFirstName != null)
					employee.setName(newFirstName);
				if (newLastName != null)
					employee.setSurname(newLastName);
				if (newEmail != null)
					employee.setEmail(newEmail);
			}
		}
		return employees;
	}
	
	
}
