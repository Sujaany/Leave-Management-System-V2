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

import com.invicta.lms.dto.LieuLeaveDtoRequest;
import com.invicta.lms.dto.LieuLeaveDtoResponse;
import com.invicta.lms.dto.mapper.LieuLeaveRequestDtoMapper;
import com.invicta.lms.entity.mapper.LieuLeaveRequestMapper;
import com.invicta.lms.service.LieuLeaveRequestService;
import com.invicta.lms.service.UserService;
import com.invicta.lms.validation.LieuLeaveRequestValidation;

@RestController
@RequestMapping("/lieuLeaveRequest")
public class LieuLeaveRequestController {

	@Autowired
	private LieuLeaveRequestService lieuleaveRequestService;
	@Autowired
	private UserService userService;
	@Autowired
	private LieuLeaveRequestValidation lieuLeaveRequestValidation;

	@GetMapping
	public ResponseEntity<List<LieuLeaveDtoResponse>> getAllLieuLeaveRequest() {

		return new ResponseEntity<>(LieuLeaveRequestMapper.mapLieuLeaveRequestListToLieuLeaveRequestDtoList(
				lieuleaveRequestService.viewAllLieuLeaveRequest()), HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<?> applyLieuLeaveRequest(@RequestBody LieuLeaveDtoRequest leaveDtoRequest) {
		lieuLeaveRequestValidation.validationLieuLeaveRequest(leaveDtoRequest);
		if (!lieuLeaveRequestValidation.getErrors().isEmpty()) {
			return new ResponseEntity<>(lieuLeaveRequestValidation.getErrors(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(
				LieuLeaveRequestMapper.mapLieuLeaveRequestToLieuLeaveRequestDto(lieuleaveRequestService.applyLeieuLeave(
						LieuLeaveRequestDtoMapper.mapLieuLeaveRequestDtoToLieuLeaveRequest(leaveDtoRequest),
						userService.findUserById(leaveDtoRequest.getUserId()))),
				HttpStatus.CREATED);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteLieuLeaveRequest(@PathVariable("id") Long id) {
		return new ResponseEntity<>(lieuleaveRequestService.deleteLieuLeaveRequest(id), HttpStatus.OK);

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateLieuLeaveRequest(@RequestBody LieuLeaveDtoRequest lieuleaveDtoRequest,
			@PathVariable("id") Long id) {
		return new ResponseEntity<>(LieuLeaveRequestMapper
				.mapLieuLeaveRequestToLieuLeaveRequestDto(lieuleaveRequestService.updateLieuLeaveRequest(id,
						LieuLeaveRequestDtoMapper.mapLieuLeaveRequestDtoToLieuLeaveRequest(lieuleaveDtoRequest),
						userService.findUserById(lieuleaveDtoRequest.getUserId()))),
				HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getLieuLeaveRequest(@PathVariable Long id) {
		if (lieuleaveRequestService.findLieuLeaveRequestById(id) != null) {
			return new ResponseEntity<>(LieuLeaveRequestMapper.mapLieuLeaveRequestToLieuLeaveRequestDto(
					lieuleaveRequestService.findLieuLeaveRequestById(id)), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/findbyUserId/{userId}")
	public ResponseEntity<?> getLieuLeaveRequestFindByUserId(@PathVariable("userId") Long id) {
		if (lieuleaveRequestService.findByUser(id) != null) {
			return new ResponseEntity<>(LieuLeaveRequestMapper.mapLieuLeaveRequestListToLieuLeaveRequestDtoList(
					lieuleaveRequestService.findByUser(id)), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}
}
