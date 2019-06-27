package com.invicta.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invicta.lms.entity.LeaveType;
import com.invicta.lms.service.LeaveTypeService;


@RestController
@RequestMapping("/leaveType")
public class LeaveTypeController {

	@Autowired
	LeaveTypeService leaveTypeService;

	@GetMapping
	public ResponseEntity<List<LeaveType>> getLeaveType() {
		return new ResponseEntity<>(leaveTypeService.viewAllLeaveType(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getLeaveTypeById(@PathVariable("id") Integer id) {
		return new ResponseEntity<LeaveType>(leaveTypeService.findLeaveTypeById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> addLeaveType(@RequestBody LeaveType leaveType) {
		return new ResponseEntity<>(leaveTypeService.addLeaveType(leaveType), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<LeaveType> updateLeaveType(@RequestBody LeaveType leaveType, @PathVariable Integer id) {
		return new ResponseEntity<LeaveType>(leaveTypeService.updateLeaveType(id, leaveType), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteLeaveType(@PathVariable Integer id) {
		return new ResponseEntity<>(leaveTypeService.deleteLeaveType(id), HttpStatus.OK);
	}
}
