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
import org.springframework.web.bind.annotation.RestController;

import com.invicta.lms.entity.LeaveType;
import com.invicta.lms.service.LeaveTypeService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class LeaveTypeController {
	
	@Autowired
	LeaveTypeService leaveTypeService;

	@GetMapping("/leaveType")
	public List<LeaveType> getLeaveType() {
		return leaveTypeService.viewAllLeaveType();
	}

	@PostMapping("/leaveType")
	public ResponseEntity<String> addLeaveType(@RequestBody LeaveType leaveType) {
		String msg = null;
		if (leaveTypeService.addLeaveType(leaveType)) {
			msg = "CREATED";
		} else {
			msg = "NOT CREATED";
		}
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
	 @PutMapping("/leaveType/{id}")
	  public void updateLeaveType(@RequestBody LeaveType leaveType,@PathVariable Integer id) {
		 leaveTypeService.updateLeaveType(id, leaveType);
	  }
	
	@DeleteMapping("/leaveType/{id}")
	  public void deleteLeaveType(@PathVariable Integer id) {
		leaveTypeService.deleteLeaveType(id);
	  }

}

