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

import com.invicta.lms.entity.Designation;
import com.invicta.lms.service.DesignationService;

@RestController
@RequestMapping("designation")
public class DesignationController {
	@Autowired
	DesignationService designationService;

	@PostMapping
	public ResponseEntity<?> addDesignation(@RequestBody Designation designation){
		return new ResponseEntity<>(designationService.addDesignation(designation),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Designation>> getDesignation(){
		return new ResponseEntity<List<Designation>>(designationService.viewAllDesignation(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?>getDesignationById(@PathVariable("id") Long id){
		return new ResponseEntity<Designation>(designationService.findDesignationById(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Designation>updateDesignation(@RequestBody Designation designation,@PathVariable("id") Long id){
		return new ResponseEntity<Designation>(designationService.updateDesignation(id, designation), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>deleteById(@PathVariable("id") Long id){
		return new ResponseEntity<>(designationService.deleteDesignation(id), HttpStatus.OK);
	}
}
