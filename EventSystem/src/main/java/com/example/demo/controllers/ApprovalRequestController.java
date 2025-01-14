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

import com.example.demo.services.ApprovalRequestServices;
import com.example.demo.users.ApprovalRequest;

@RestController
@RequestMapping("requests")
public class ApprovalRequestController {
	@Autowired
	ApprovalRequestServices approvalRequestServices;
	
	@PostMapping("/addRequest")
	public List<ApprovalRequest> addApprovalRequest(@RequestBody ApprovalRequest aRequest) {
		return addApprovalRequest(aRequest);
	}
	
	@DeleteMapping("/removeRequest")
	public List<ApprovalRequest> removeApprovalRequest(@RequestParam Integer id) {
		return removeApprovalRequest(id);
	}

	@GetMapping("/allRequests")
	public List<ApprovalRequest> getAllRequests(){
		return getAllRequests();
	}
	
	@GetMapping("/allUnprocessedRequests")
	public List<ApprovalRequest> getAllUnprocessedRequests(){
		return getAllUnprocessedRequests();
	}

	@GetMapping("/allUnprocessedRequestsByType")
	public List<ApprovalRequest> getAllUnprocessedRequestsByType(@RequestParam String type){
		return getAllUnprocessedRequestsByType(type);
	}
	
	@GetMapping("/allRequestsByEmployeeId")
	public List<ApprovalRequest> getAllRequestsByEmployeeId(@RequestParam Integer employeeId){
		return getAllRequestsByEmployeeId(employeeId);
	}
	
	@GetMapping("/allDeletionByEmployeeId")
	public List<ApprovalRequest> getAllDeletionsByEmployeeId(@RequestParam Integer employeeId){
		return getAllDeletionsByEmployeeId(employeeId);
	}
	
	@PutMapping("/rejectRequest")
	public List<ApprovalRequest> rejectRequest(@RequestParam Integer requestId, @RequestParam Integer employeeId,@RequestParam String comments){
		return rejectRequest(requestId, employeeId, comments);
	}
	
	@PutMapping("/approveRequest")
	public List<ApprovalRequest> approveRequest(@RequestParam Integer requestId, @RequestParam Integer employeeId,@RequestParam String comments){
		return approveRequest(requestId, employeeId, comments);
	}
}
