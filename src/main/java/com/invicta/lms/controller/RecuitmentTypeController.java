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

import com.invicta.lms.entity.RecuitmentType;
import com.invicta.lms.service.RecuitmentTypeService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/recuitmentType")
public class RecuitmentTypeController {
	
	@Autowired
	RecuitmentTypeService recuitmentTypeService;

	@GetMapping
	public ResponseEntity<List<RecuitmentType>> getRecuitmentType() {
		return new ResponseEntity<>(recuitmentTypeService.viewAllRecuitmentType(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?>getRecuitmentTypeById(@PathVariable("id") Integer id){
		return new ResponseEntity<RecuitmentType>(recuitmentTypeService.findRecuitmentTypeById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> addRecuitmentType(@RequestBody RecuitmentType recuitmentType) {
		return new ResponseEntity<>(recuitmentTypeService.addRecuitmentType(recuitmentType),HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateRecuitmentType(@RequestBody RecuitmentType recuitmentType, @PathVariable Integer id) {
		return new ResponseEntity<RecuitmentType>(recuitmentTypeService.updateRecuitmentType(id, recuitmentType), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRecuitmentType(@PathVariable Integer id) {
		return new ResponseEntity<>(recuitmentTypeService.deleteRecuitmentType(id), HttpStatus.OK);
		}
}

