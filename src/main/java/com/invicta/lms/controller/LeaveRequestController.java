package com.invicta.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invicta.lms.dto.LeaveDtoRequest;
import com.invicta.lms.service.LeaveRequestService;
import com.invicta.lms.validation.LeaveRequestValidation;

@RestController
@RequestMapping("leaveRequest")
public class LeaveRequestController {

	@Autowired
	private LeaveRequestService leaveRequestService;

	@Autowired
	private LeaveRequestValidation leaveRequestValidation;

	@PostMapping("/requesteduser/{userid}")
	public ResponseEntity<?> addLeaveRequest(@RequestBody LeaveDtoRequest leaveDtoRequest,@PathVariable("userid") Long userId) {
		leaveRequestValidation.validationLeave(leaveDtoRequest);
		return new ResponseEntity<>(leaveRequestService.createInitialLeaveRequestProcess(leaveDtoRequest,userId), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<?> getLeaveRequest() {
		return new ResponseEntity<>(
				leaveRequestService.findAllLeaveRequest(),
				HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getLeaveRequestById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(
				leaveRequestService.findLeaveRequestById(id),
				HttpStatus.OK);
	}

	@GetMapping("/user/{userid}")
	public ResponseEntity<?> getLeaveRequestByUser(@PathVariable("userid") Long userId) {
		return new ResponseEntity<>(
				leaveRequestService.findLeaveRequestByUserId(userId), HttpStatus.OK);
	}



	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(leaveRequestService.deleteLeaveRequest(id), HttpStatus.OK);
	}
}
