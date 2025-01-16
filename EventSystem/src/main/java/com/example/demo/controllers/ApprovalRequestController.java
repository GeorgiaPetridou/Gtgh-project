
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
import com.example.demo.users.Event;

@RestController
@RequestMapping("requests")
public class ApprovalRequestController {
	@Autowired
	ApprovalRequestServices approvalRequestServices;

	@PostMapping("/makeadd")
	public List<ApprovalRequest> makeApprovalRequest(@RequestParam Integer orgAfm, @RequestBody Event e) {
		return approvalRequestServices.makeApprovalRequest(orgAfm, e);
	}

	@PostMapping("/makedelete")
	public List<ApprovalRequest> makeDeletionApprovalRequest(@RequestParam Integer orgAfm,
			@RequestParam Integer eventId) {
		return approvalRequestServices.makeDeletionApprovalRequest(orgAfm, eventId);
	}

	@DeleteMapping("/removeRequest")
	public List<ApprovalRequest> removeApprovalRequest(@RequestParam Integer id) {
		return approvalRequestServices.removeApprovalRequest(id);
	}

	@GetMapping("/allRequests")
	public List<ApprovalRequest> getAllRequests() {
		return approvalRequestServices.getAllRequests();
	}

	@GetMapping("/allUnprocessedRequests")
	public List<ApprovalRequest> getAllUnprocessedRequests() {
		return approvalRequestServices.getAllUnprocessedRequests();
	}

	@GetMapping("/allUnprocessedRequestsByType")
	public List<ApprovalRequest> getAllUnprocessedRequestsByType(@RequestParam String type) {
		return approvalRequestServices.getAllUnprocessedRequestsByType(type);
	}

	@GetMapping("/allRequestsByEmployeeId")
	public List<ApprovalRequest> getAllRequestsByEmployeeId(@RequestParam Integer employeeId) {
		return approvalRequestServices.getAllRequestsByEmployeeId(employeeId);
	}

	@GetMapping("/allDeletionByEmployeeId")
	public List<ApprovalRequest> getAllDeletionsByEmployeeId(@RequestParam Integer employeeId) {
		return approvalRequestServices.getAllDeletionsByEmployeeId(employeeId);
	}

	@PutMapping("/rejectRequest")
	public List<ApprovalRequest> rejectRequest(@RequestParam Integer requestId, @RequestParam Integer employeeId,
			@RequestParam(required = false) String comments) {
		return approvalRequestServices.rejectRequest(requestId, employeeId, comments);
	}

	@PutMapping("/approveRequest")
	public List<ApprovalRequest> approveRequest(@RequestParam Integer requestId, @RequestParam Integer employeeId,
			@RequestParam(required = false) String comments) {
		return approvalRequestServices.approveRequest(requestId, employeeId, comments);
	}
}
