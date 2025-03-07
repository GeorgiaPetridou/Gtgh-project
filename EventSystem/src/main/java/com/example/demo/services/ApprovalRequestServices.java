package com.example.demo.services;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import com.example.demo.users.ApprovalRequest;
import com.example.demo.users.Employee;
import com.example.demo.users.Event;
import com.example.demo.users.Organizer;

@Service
public class ApprovalRequestServices {

	private List<ApprovalRequest> requests = new ArrayList<ApprovalRequest>();
	@Autowired
	EmployeeServices employeeServices;
	@Autowired
	EventServices eventServices;
	@Autowired
	OrganizerServices organizerServices;

	// id generator
	private Integer UniqApprovalRequestID() {
		return requests.stream().mapToInt(ApprovalRequest::getId).max().orElse(0) + 1;
	}

	public List<ApprovalRequest> addApprovalRequest(ApprovalRequest aRequest) {
		if (requests.contains(aRequest))
			return requests;
		else {
			aRequest.setId(UniqApprovalRequestID());
			requests.add(aRequest);
			return requests;
		}
	}

	public List<ApprovalRequest> makeApprovalRequest(Integer organizerAfm, Event e) {
		// Add Event
		for (Organizer o : organizerServices.getAllOrganizers()) {
			if (o.getAfm().equals(organizerAfm)) {

				eventServices.addEvent(e, o);
				ApprovalRequest ap = new ApprovalRequest(e, o, "add");
				this.addApprovalRequest(ap);
				organizerServices.addEventToOrganizer(e, o);
				return requests;
			}

		}
		return requests;
	}

	public List<ApprovalRequest> makeDeletionApprovalRequest(Integer organizerAfm, Integer EventId) {
		for (Organizer o : organizerServices.getAllOrganizers()) {
			if (o.getAfm().equals(organizerAfm)) {
				for (Event e : eventServices.getAllEvents()) {
					if (e.getId().equals(EventId)) {
						eventServices.applyToDeleteEvent(EventId);
						ApprovalRequest ap = new ApprovalRequest(e, o, "delete");
						this.addApprovalRequest(ap);
					}
				}
			}
		}
		return requests;
	}

	public List<ApprovalRequest> removeApprovalRequest(Integer id) {
		requests.removeIf(request -> request.getId().equals(id));
		return requests;
	}

	public List<ApprovalRequest> getAllRequests() {
		return requests;
	}

	public List<ApprovalRequest> getAllUnprocessedRequests() {
		return requests.stream()
				.filter(request -> request.getTheEvent().getStatus()
						.equals("toBeAdded")/* || request.getTheEvent().getStatus().equals("toBeDeleted") */)
				.collect(Collectors.toList());

	}

	public List<ApprovalRequest> getAllUnprocessedRequestsByType(String type) {
		List<ApprovalRequest> filteredRequests = getAllUnprocessedRequests().stream()
				.filter(request -> request.getType().equals(type)).collect(Collectors.toList());
		return filteredRequests;
	}

	public List<ApprovalRequest> getAllRequestsByEmployeeId(Integer employeeId) {
		List<ApprovalRequest> filteredRequests = requests.stream()
				.filter(request -> request.getHandledBy().getId().equals(employeeId)).collect(Collectors.toList());
		return filteredRequests;
	}

	public List<ApprovalRequest> getAllDeletionsByEmployeeId(Integer employeeId) {
		List<ApprovalRequest> filteredRequests = requests.stream()
				.filter(request -> request.getId().equals(employeeId) && request.getSubmittedBy().equals(null))
				.collect(Collectors.toList());
		return filteredRequests;
	}

	public void addInfo(ApprovalRequest request, Employee e, String comment) {
		request.setHandledBy(e);
		if (comment != null) {
			request.setComments(comment);
		}
		request.setClosedAt(LocalDateTime.now());

	}

	public List<ApprovalRequest> rejectRequest(Integer requestId, Integer employeeId, String comments) {
		for (Employee employee : employeeServices.getAllEmployees()) {
			if (employee.getId().equals(employeeId)) {
				for (ApprovalRequest request : requests) {
					if (request.getId().equals(requestId)) {
						if (request.getType().equals("add")) {
							request.setStatus("rejected");
							request.setHandledBy(employee);
							request.setClosedAt(LocalDateTime.now());
							if (comments != null) {
								request.setComments(comments);
							}
							eventServices.denyEvent(request.getTheEvent().getId());

						}
						if (request.getType().equals("delete")) {
							request.setStatus("rejected");
							this.addInfo(request, employee, comments);
							eventServices.approveEvent(request.getTheEvent().getId());
						}

					}
				}
			}
		}
		return requests;
	}

	public List<ApprovalRequest> approveRequest(Integer requestId, Integer employeeId, String comments) {
		for (Employee employee : employeeServices.getAllEmployees()) {
			if (employee.getId().equals(employeeId)) {
				for (ApprovalRequest request : requests) {
					if (request.getId().equals(requestId)) {
						if (request.getType().equals("add")) {
							request.setStatus("approved");
							this.addInfo(request, employee, comments);
							eventServices.approveEvent(request.getTheEvent().getId());
						}
						if (request.getType().equals("delete")) {
							request.setStatus("approved");
							this.addInfo(request, employee, comments);
							eventServices.deleteEvent(request.getTheEvent().getId());
						}

					}
				}
			}
		}
		return requests;
	}

}
