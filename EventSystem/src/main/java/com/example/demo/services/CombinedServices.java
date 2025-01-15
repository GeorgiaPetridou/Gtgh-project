//package com.example.demo.services;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.users.ApprovalRequest;
//import com.example.demo.users.Employee;
//import com.example.demo.users.Event;
//
//@Service
//public class CombinedServices {
//
//	@Autowired
//	ApprovalRequestServices approvalRequestServices;
//	@Autowired
//	EmployeeServices employeeServices;
//	@Autowired
//	EventServices eventServices;
//
//	public List<ApprovalRequest> rejectRequest(Integer requestId,Integer employeeId, String comments){
//		for(Employee employee : employeeServices.getAllEmployees()) {
//			if(employee.getId().equals(employeeId)) {
//				for(ApprovalRequest request: approvalRequestServices.getAllRequests()) {
//					if(request.getId().equals(requestId)) {
//						if(request.getType().equals("add")) {
//							request.setStatus("rejected");
//							eventServices.denyEvent(request.getTheEvent().getId());
//						}
//						if(request.getType().equals("delete")) {
//							request.setStatus("rejected");
//							//event.status remains approved
//						}
//						request.setHandledBy(employee);
//						request.setComments(comments);
//						request.setClosedAt(LocalDateTime.now());
//					}
//				}
//			}
//		}
//		return approvalRequestServices.getAllRequests();
//	}
//		
//	public List<ApprovalRequest> approveRequest(Integer requestId, Integer employeeId, String comments){
//		for(Employee employee : employeeServices.getAllEmployees()) {
//			if(employee.getId().equals(employeeId)) {
//				for(ApprovalRequest request: approvalRequestServices.getAllRequests()) {
//					if(request.getId().equals(requestId)) {
//						if(request.getType().equals("add")) {
//							request.setStatus("approved");
//							eventServices.approveEvent(request.getTheEvent().getId());
//						}
//						if(request.getType().equals("delete")) {
//							request.setStatus("approved");
//							eventServices.deleteEvent(request.getTheEvent().getId());
//						}
//						request.setHandledBy(employee);
//						request.setComments(comments);
//						request.setClosedAt(LocalDateTime.now());
//					}
//				}
//			}
//		}
//		return approvalRequestServices.getAllRequests();
//	}
//	
//	//Employee Deletes an Event without a request
//		public List<Event> deleteEventWithoutRequest(Integer eventId, Integer employeeId){
//			for(Event e: eventServices.getAllEvents()) {
//				if(e.getId() == eventId) {
//					e.setStatus("Deleted");
//					//create approval request 
//					//put the organizer = null, type = "delete"
//					ApprovalRequest request = new ApprovalRequest(e, null, "delete");
//					approvalRequestServices.addApprovalRequest(request);
//					this.approveRequest(request.getId(), employeeId, null);
//				}
//			}
//			return eventServices.getAllEvents();
//		}
//}
