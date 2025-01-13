package com.example.demo.services;


import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.users.Event;
import com.example.demo.users.Organizer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.users.ApprovalRequest;
import com.example.demo.users.Employee;

public class ApprovalRequestServices {

	private List<ApprovalRequest> requests = new ArrayList<ApprovalRequest>();
	
	EmployeeServices employeeServices;
	

	public List<ApprovalRequest> getAllRequests(){
		return requests;
	}
	
	public List<ApprovalRequest> getAllUnprocessedRequests(){
		List<ApprovalRequest> filteredRequests = requests.stream()
                .filter(request -> request.getStatus().equals(null))
                .collect(Collectors.toList());
		return filteredRequests;
	}
	
	public List<ApprovalRequest> getAllUnprocessedRequestsByType(String type){
		List<ApprovalRequest> filteredRequests = getAllUnprocessedRequests().stream()
                .filter(request -> request.getType().equals(type))
                .collect(Collectors.toList());
		return filteredRequests;
	}
	
	public List<ApprovalRequest> getAllRequestsByEmployeeId(Integer employeeId){
		List<ApprovalRequest> filteredRequests = requests.stream()
                .filter(request -> request.getId().equals(employeeId))
                .collect(Collectors.toList());
		return filteredRequests;
	}
	
	public List<ApprovalRequest> getAllDeletionsByEmployeeId(Integer employeeId){
		List<ApprovalRequest> filteredRequests = requests.stream()
                .filter(request -> request.getId() == employeeId && request.getSubmittedBy().equals(null))
                .collect(Collectors.toList());
		return filteredRequests;
	}
	
	public boolean addApprovalRequest(ApprovalRequest aRequest) {
		if (!requests.contains(aRequest)) {
			requests.add(aRequest);
			return true;
		}else {
			return false;
		}
	}
	
	public List<ApprovalRequest> removeApprovalRequest(Integer id) {
		requests.removeIf(request -> request.getId() == id);
		return requests;
	}

	public List<ApprovalRequest> rejectRequest(Integer requestId,Integer employeeId, String comments){
		for(Employee employee : employeeServices.getAllEmployees()) {
			if(employee.getId().equals(employeeId)) {
				for(ApprovalRequest request: requests) {
					if(request.getId().equals(requestId)) {
						if(request.getType().equals("add")) {
							request.setStatus("rejected");
							request.getTheEvent().setStatus("denied");
						}
						if(request.getType().equals("delete")) {
							request.setStatus("rejected");
							//request.getTheEvent().setStatus("approved");
						}
						request.setHandledBy(employee);
						request.setComments(comments);
						request.setClosedAt(LocalDateTime.now());
					}
				}
			}
		}
		return requests;
	}
		
	public List<ApprovalRequest> approveRequest(Integer requestId, Integer employeeId, String comments){
		for(Employee employee : employeeServices.getAllEmployees()) {
			if(employee.getId().equals(employeeId)) {
				for(ApprovalRequest request: requests) {
					if(request.getId().equals(requestId)) {
						if(request.getType().equals("add")) {
							request.setStatus("approved");
							request.getTheEvent().setStatus("added");
						}
						if(request.getType().equals("delete")) {
							request.setStatus("approved");
							request.getTheEvent().setStatus("deleted");
						}
						request.setHandledBy(employee);
						request.setComments(comments);
						request.setClosedAt(LocalDateTime.now());
					}
				}
			}
		}
		return requests;
	}
	
	
}
