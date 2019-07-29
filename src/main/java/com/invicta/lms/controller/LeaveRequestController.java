package com.invicta.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invicta.lms.dto.LeaveDtoRequest;
import com.invicta.lms.dto.LeaveProcessDtoRequest;
import com.invicta.lms.dto.mapper.LeaveRequestDtoMapper;
import com.invicta.lms.dto.mapper.LeaveRequestProcessDtoMapper;
import com.invicta.lms.entity.mapper.LeaveRequestMapper;
import com.invicta.lms.service.LeaveRequestService;
import com.invicta.lms.service.LeaveTypeService;
import com.invicta.lms.service.UserService;
import com.invicta.lms.validation.LeaveRequestValidation;

@RestController
@RequestMapping("leaveRequest")
public class LeaveRequestController {

	@Autowired
	private LeaveRequestService leaveRequestService;
	@Autowired
	private UserService userService;
	@Autowired
	private LeaveTypeService leaveTypeService;
	@Autowired
	private LeaveRequestValidation leaveRequestValidation;

	@PostMapping
	public ResponseEntity<?> addLeaveRequest(@RequestBody LeaveDtoRequest leaveDtoRequest) {
		leaveRequestValidation.validationLeave(leaveDtoRequest);
		return new ResponseEntity<>(leaveRequestService.createInitialLeaveRequestProcess(
				LeaveRequestDtoMapper.mapLeaveDtoRequestToLeaveRequest(leaveDtoRequest),
				userService.findUserById(leaveDtoRequest.getRequestedBy()),
				leaveTypeService.findLeaveTypeById(leaveDtoRequest.getLeaveType())), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<?> getLeaveRequest() {
		return new ResponseEntity<>(
				LeaveRequestMapper.mapLeaveRequestListToLeaveDtoResponseList(leaveRequestService.viewAllLeaveRequest()),
				HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getLeaveRequestById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(
				LeaveRequestMapper.mapLeaveRequestToLeaveDtoResponse(leaveRequestService.findLeaveRequestById(id)),
				HttpStatus.OK);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<?> getLeaveRequestByUser(@PathVariable("id") Long id) {
		return new ResponseEntity<>(LeaveRequestMapper.mapLeaveRequestListToLeaveDtoResponseList(
				leaveRequestService.viewLeaveRequestByUser(id)), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateLeaveRequest(@RequestBody LeaveDtoRequest leaveDtoRequest,
			@PathVariable("id") Long id) {
		return new ResponseEntity<>(
				LeaveRequestMapper.mapLeaveRequestToLeaveDtoResponse(leaveRequestService.updateLeaveRequest(id,
						LeaveRequestDtoMapper.mapLeaveDtoRequestToLeaveRequest(leaveDtoRequest),
						userService.findUserById(leaveDtoRequest.getRequestedBy()),
						leaveTypeService.findLeaveTypeById(leaveDtoRequest.getLeaveType()))),
				HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(leaveRequestService.deleteLeaveRequest(id), HttpStatus.OK);
	}
}
