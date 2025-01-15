package com.example.demo.services;

import java.util.List;

import com.example.demo.users.ApprovalRequest;
import com.example.demo.users.Event;

public interface ApprovalRequestService {
	List<ApprovalRequest> addApprovalRequest(ApprovalRequest aRequest);
	List<ApprovalRequest> approveRequest(Integer requestId, Integer employeeId, String comments);
}
