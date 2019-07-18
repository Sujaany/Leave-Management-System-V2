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

import com.invicta.lms.entity.LeaveDaysProcessor;
import com.invicta.lms.service.LeaveDaysProcessorService;
import com.invicta.lms.service.LeaveTypeService;
import com.invicta.lms.service.UserService;

@RestController
@RequestMapping("leaveDaysProcessor")
public class LeaveDaysProcessorController {
	
	@Autowired
	private LeaveDaysProcessorService leaveDaysProcessorService;
	
	@Autowired
	private LeaveTypeService leaveTypeService;
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping
	public ResponseEntity<List<LeaveDaysProcessor>> get() {
		return new ResponseEntity<>(leaveDaysProcessorService.viewAllLeaveDaysProcessor(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?>getLeaveDaysProcessorById(@PathVariable("id") Long id){
		return new ResponseEntity<LeaveDaysProcessor>(leaveDaysProcessorService.findLeaveDaysProcessorById(id), HttpStatus.OK);
	}

//	@PostMapping
//	public ResponseEntity<?> createLeaveDaysProcessor(@RequestBody LeaveDaysProcessor leaveDaysProcessor) {
//		return new ResponseEntity<>(leaveDaysProcessorService.addLeaveDaysProcessor(leaveDaysProcessor),HttpStatus.CREATED);
//		}
//	
//	@PutMapping("/{id}")
//	public ResponseEntity<?> editLeaveDaysProcessor(@RequestBody LeaveDaysProcessor leaveDaysProcessor, @PathVariable Long id) {
//		return new ResponseEntity<LeaveDaysProcessor>(leaveDaysProcessorService.updateLeaveDaysProcessor(id, leaveDaysProcessor), HttpStatus.OK);
//		}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteLeaveDaysProcessor(@PathVariable Long id) {
		return new ResponseEntity<>(leaveDaysProcessorService.deleteLeaveDaysProcessor(id), HttpStatus.OK);
	}
}
