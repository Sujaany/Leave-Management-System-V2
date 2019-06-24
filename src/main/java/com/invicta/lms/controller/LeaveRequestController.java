package com.invicta.lms.controller;

import java.util.List;

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

import com.invicta.lms.entity.LeaveRequest;
import com.invicta.lms.service.LeaveRequestService;

@RestController
@RequestMapping("leaveRequest")
public class LeaveRequestController {
	
	@Autowired
	LeaveRequestService leaveRequestService;
	
	@PostMapping("/create")
	public ResponseEntity<?> addLeaveRequest(@RequestBody LeaveRequest leaveRequest){
		return new ResponseEntity<>(leaveRequestService.addLeaveRequest(leaveRequest),HttpStatus.CREATED);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<LeaveRequest>> getLeaveRequest(){
		return new ResponseEntity<List<LeaveRequest>>(leaveRequestService.viewAllLeaveRequest(), HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?>getLeaveRequestById(@PathVariable("id") Long id){
		return new ResponseEntity<LeaveRequest>(leaveRequestService.findLeaveRequestById(id), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<LeaveRequest>updateLeaveRequest(@RequestBody LeaveRequest leaveRequest,@PathVariable("id") Long id){
		return new ResponseEntity<LeaveRequest>(leaveRequestService.updateLeaveRequest(id, leaveRequest), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?>deleteById(@PathVariable("id") Long id){
		return new ResponseEntity<>(leaveRequestService.deleteLeaveRequest(id), HttpStatus.OK);
	}
}

