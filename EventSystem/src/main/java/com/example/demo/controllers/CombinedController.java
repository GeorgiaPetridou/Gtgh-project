package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.CombinedServices;
import com.example.demo.users.ApprovalRequest;
import com.example.demo.users.Event;

@RestController
@RequestMapping("takeInfo")
public class CombinedController {
	
	@Autowired
	CombinedServices takeInfoServices;
	
	@PutMapping("/rejectRequest")
	public List<ApprovalRequest> rejectRequest(@RequestParam Integer requestId, @RequestParam Integer employeeId,@RequestParam String comments){
		return rejectRequest(requestId, employeeId, comments);
	}
	
	@PutMapping("/approveRequest")
	public List<ApprovalRequest> approveRequest(@RequestParam Integer requestId, @RequestParam Integer employeeId,@RequestParam String comments){
		return approveRequest(requestId, employeeId, comments);
	}
	
	@PutMapping("/deleteWithoutRequest")
	public List<Event> deleteEventWithoutRequest(@RequestParam Integer eventId,@RequestParam Integer employeeId){
		return deleteEventWithoutRequest(eventId,employeeId);
	}
	
}
