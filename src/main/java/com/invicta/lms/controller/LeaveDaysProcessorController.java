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
import com.invicta.lms.dto.LeaveDaysProcessorDtoRequest;
import com.invicta.lms.dto.LeaveDaysProcessorDtoResponse;
import com.invicta.lms.dto.mapper.LeaveDaysProcessorDtoMapper;
import com.invicta.lms.entity.mapper.LeaveDaysProcessorMapper;
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
	
	@PostMapping 
	public ResponseEntity<?> createLeaveDaysProcessor(@RequestBody LeaveDaysProcessorDtoRequest leaveDaysProcessorDtoRequest){
		return new ResponseEntity<> (LeaveDaysProcessorMapper.mapLeaveDaysProcessorToLeaveDaysProcessorDto(
				
				leaveDaysProcessorService.addLeaveDaysProcessor(
				
				LeaveDaysProcessorDtoMapper.mapLeaveDaysProcessorDtoToLeaveDaysProcessor(
						leaveDaysProcessorDtoRequest),
				userService.findUserById(leaveDaysProcessorDtoRequest.getUser()),
				leaveTypeService.findLeaveTypeById(leaveDaysProcessorDtoRequest.getLeaveType()))),HttpStatus.CREATED);			
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateLeaveDaysProcessor(@RequestBody LeaveDaysProcessorDtoRequest leaveDaysProcessorDtoRequest,
			@PathVariable("id") Long id) {
		return new ResponseEntity<>(LeaveDaysProcessorMapper.mapLeaveDaysProcessorToLeaveDaysProcessorDto(leaveDaysProcessorService.updateLeaveDaysProcessor(id,
				LeaveDaysProcessorDtoMapper.mapLeaveDaysProcessorDtoToLeaveDaysProcessor(leaveDaysProcessorDtoRequest),
				userService.findUserById(leaveDaysProcessorDtoRequest.getUser()),
				leaveTypeService.findLeaveTypeById(leaveDaysProcessorDtoRequest.getLeaveType()))), HttpStatus.OK);
	}
		
	@GetMapping
	public ResponseEntity<List<LeaveDaysProcessorDtoResponse>> getLeaveDaysProcessor(){
		return new ResponseEntity<>(LeaveDaysProcessorMapper.mapLeaveDaysProcessorToLeaveDaysProcessorDtoList(leaveDaysProcessorService.viewAllLeaveDaysProcessor()),HttpStatus.OK);
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<?> getLeaveDaysProcessorById(@PathVariable("id") Long id){
		if(userService.findUserById(id)!=null) {
			return new ResponseEntity<> (leaveDaysProcessorService.findLeaveDaysProcessorById(id),HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/findbyUserId/{userId}")
	public ResponseEntity<?> findLeaveDaysByUserId(@PathVariable("userId") Long id) {
		if (leaveDaysProcessorService.findLeaveDaysByUserId(id) != null) {
			return new ResponseEntity<>(LeaveDaysProcessorMapper.mapLeaveDaysProcessorToLeaveDaysProcessorDtoList(
					leaveDaysProcessorService.findLeaveDaysByUserId(id)), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/findbyUserId/{userId}/leaveType/{leaveTypeId}")
	public ResponseEntity<?> findLeaveDaysByUserIdAndleaveType(@PathVariable("userId") Long userId,@PathVariable("leaveTypeId") Long leaveTypeId) {
		
		if (leaveDaysProcessorService.findLeaveDaysByUserAndLeaveType(userId, leaveTypeId) != null) {
			return new ResponseEntity<>(LeaveDaysProcessorMapper.mapLeaveDaysProcessorToLeaveDaysProcessorDtoList(
					leaveDaysProcessorService.findLeaveDaysByUserAndLeaveType(userId, leaveTypeId)), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("sumLeaveDays/userId/{userId}/leaveType/{leaveTypeId}")
	public ResponseEntity<?> sumLeaveDaysByUserAndLeaveType(@PathVariable("userId") Long userId,@PathVariable("leaveTypeId") Long leaveTypeId) {
		
		if (leaveDaysProcessorService.sumLeaveDaysByUserAndLeaveType(userId, leaveTypeId) != null) {
			return new ResponseEntity<>(
					leaveDaysProcessorService.sumLeaveDaysByUserAndLeaveType(userId, leaveTypeId), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(leaveDaysProcessorService.deleteLeaveDaysProcessor(id), HttpStatus.OK);
	}
}
