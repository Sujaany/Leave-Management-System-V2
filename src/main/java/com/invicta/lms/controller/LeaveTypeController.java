package com.invicta.lms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.invicta.lms.dto.LeaveTypeDto;
import com.invicta.lms.dto.mapper.LeaveTypeSaveDtoMapper;
import com.invicta.lms.entity.LeaveType;
import com.invicta.lms.entity.mapper.LeaveTypeMapper;
import com.invicta.lms.service.LeaveTypeService;
import com.invicta.lms.validation.LeaveTypeValidation;

@RestController
@RequestMapping("/leaveType")
public class LeaveTypeController {

	@Autowired
	LeaveTypeService leaveTypeService;
	@Autowired
	LeaveTypeValidation leaveTypeValidation;

	@GetMapping
	public ResponseEntity<List<LeaveTypeDto>> getLeaveType() {
		return new ResponseEntity<>(
				LeaveTypeMapper.mapLeaveTypeListToLeaveTypeDtoList(leaveTypeService.viewAllLeaveType()), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getLeaveTypeById(@PathVariable("id") Long id) {
		if (leaveTypeService.findLeaveTypeById(id) != null) {
			return new ResponseEntity<>(
					LeaveTypeMapper.mapLeaveTypeToLeaveTypeDto(leaveTypeService.findLeaveTypeById(id)), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PostMapping
	public ResponseEntity<?> addLeaveType(@Valid @RequestBody LeaveTypeDto leaveTypeDto) {
		leaveTypeValidation.validationLeaveType(leaveTypeDto);
		if (!leaveTypeValidation.getErrors().isEmpty()) {
			return new ResponseEntity<>(leaveTypeValidation.getErrors(), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(
				LeaveTypeMapper.mapLeaveTypeToLeaveTypeDto(leaveTypeService
						.addLeaveType(LeaveTypeSaveDtoMapper.mapLeaveTypesaveDtoToLeaveType(leaveTypeDto))),
				HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateLeaveType(@RequestBody LeaveTypeDto leaveTypeDto, @PathVariable Long id) {
		leaveTypeValidation.validationLeaveType(leaveTypeDto);
		if (!leaveTypeValidation.getErrors().isEmpty()) {
			return new ResponseEntity<>(leaveTypeValidation.getErrors(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<LeaveType>(leaveTypeService.updateLeaveType(id,
				LeaveTypeSaveDtoMapper.mapLeaveTypesaveDtoToLeaveType(leaveTypeDto)), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteLeaveType(@PathVariable Long id) {
		return new ResponseEntity<>(leaveTypeService.deleteLeaveType(id), HttpStatus.OK);
	}

	@GetMapping("/checkAvailability")
	public ResponseEntity<?> leaveTypenameAvailability(@RequestParam(value = "leaveType") String leaveType) {
		Map<String, String> errors = new HashMap<>();

		errors.clear();
		if (leaveTypeService.existsByleaveType(leaveType)) {
			errors.put("LeaveType", "Leave type Already exist");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
		}

		errors.put("LeaveType", "Not exist");

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(errors);

	}
}
