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
	

	public List<ApprovalRequest> getAllRequests(){
		return requests;
	}
	
	public List<ApprovalRequest> getAllRequestsById(Integer employeeId){
		List<ApprovalRequest> filteredRequests = requests.stream()
                .filter(request -> request.getId().equals(employeeId))
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
	
	public List<ApprovalRequest> updateApprovalRequest(Integer id, Employee handledBy, String comments) {
		for ( ApprovalRequest request : requests) {
			if(request.getId().equals(id)) {
				if (comments != null)
					request.setComments(comments);
				if (!handledBy.getId().equals(null))
					request.setHandledBy(handledBy);
				request.setClosedAt(LocalDateTime.now());
			}
		}
		return requests;
	}

	
//	public void updateApprovalRequest(Integer handledBy, Integer day, String month, Integer year, String comment) {
//		
//		
//		.setHandledBy(handledBy);
//		.setClosedAt(day, month, year);
//		.setComments(comment);
//	}
}
