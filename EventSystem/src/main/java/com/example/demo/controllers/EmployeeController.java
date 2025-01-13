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

import com.example.demo.services.EmployeeServices;
import com.example.demo.users.Employee;

@RestController
@RequestMapping("employees")
public class EmployeeController {
	@Autowired
	EmployeeServices employeeServices;
	
	@GetMapping("/AllEmployees")
	public List<Employee> getAllEmployees(){
		return employeeServices.getAllEmployees();
	}
	
	@PostMapping("/addEmployee")
	public List<Employee> addEmployee(@RequestBody Employee anEmployee) {
		return employeeServices.addEmployee(anEmployee);
	}
	
	@DeleteMapping("/removeEmployee")
	public List<Employee> removeEmployee(@RequestParam Integer id){
		return removeEmployee(id);
	}
	
	@PutMapping("/updateEmployee")
	public List<Employee> updateEmployee(@RequestParam Integer id, String newFirstName, String newLastName, String newEmail){
		return updateEmployee(id, newFirstName, newLastName, newEmail);
	}
	
	
}