package com.example.demo.services;

import java.util.List;

import com.example.demo.users.ApprovalRequest;


public interface ApprovalRequestService {
	 List<ApprovalRequest> rejectRequest(Integer requestId,Integer employeeId, String comments);
	 List<ApprovalRequest> approveRequest(Integer requestId, Integer employeeId, String comments);
}
