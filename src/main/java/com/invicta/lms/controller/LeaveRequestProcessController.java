package com.invicta.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invicta.lms.dto.LeaveProcessDtoRequest;
import com.invicta.lms.dto.mapper.LeaveRequestProcessDtoMapper;
import com.invicta.lms.enums.LeaveRequestAction;
import com.invicta.lms.service.LeaveRequestProcessService;
import com.invicta.lms.service.UserService;

@RestController
@RequestMapping("leaveRequestProcess")
public class LeaveRequestProcessController {
	@Autowired
	LeaveRequestProcessService leaveRequestProcessService;
	@Autowired
	private UserService userService;

	@PostMapping("/accept")
	public ResponseEntity<?> acceptLeaveRequest(@RequestBody LeaveProcessDtoRequest leaveProcessDtoRequest) {
		if (leaveProcessDtoRequest != null) {
			return new ResponseEntity<>(leaveRequestProcessService.processLeaveRequest(LeaveRequestProcessDtoMapper.LeaveRequestProcessDtoToLeaveRequestProcess(leaveProcessDtoRequest),
					LeaveRequestAction.ACCEPTED, userService.findUserById(leaveProcessDtoRequest.getProcessedBy()),leaveProcessDtoRequest.getLeaveRequest()),
					HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/reject")
	public ResponseEntity<?> rejectLeaveRequest(@RequestBody LeaveProcessDtoRequest leaveProcessDtoRequest) {
		if (leaveProcessDtoRequest != null) {
			return new ResponseEntity<>(leaveRequestProcessService.processLeaveRequest(LeaveRequestProcessDtoMapper.LeaveRequestProcessDtoToLeaveRequestProcess(leaveProcessDtoRequest),
					LeaveRequestAction.REJECTED, userService.findUserById(leaveProcessDtoRequest.getProcessedBy()),leaveProcessDtoRequest.getLeaveRequest()),
					HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/cancel")
	public ResponseEntity<?> cancelLeaveRequest(@RequestBody LeaveProcessDtoRequest leaveProcessDtoRequest) {
		if (leaveProcessDtoRequest != null) {
			return new ResponseEntity<>(leaveRequestProcessService.processLeaveRequest(LeaveRequestProcessDtoMapper.LeaveRequestProcessDtoToLeaveRequestProcess(leaveProcessDtoRequest),
					LeaveRequestAction.CANCELED, userService.findUserById(leaveProcessDtoRequest.getProcessedBy()),leaveProcessDtoRequest.getLeaveRequest()),
					HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	@PostMapping("/reapply")
	public ResponseEntity<?> reapplyLeaveRequest(@RequestBody LeaveProcessDtoRequest leaveProcessDtoRequest) {
		if (leaveProcessDtoRequest != null) {
			return new ResponseEntity<>(leaveRequestProcessService.processLeaveRequest(LeaveRequestProcessDtoMapper.LeaveRequestProcessDtoToLeaveRequestProcess(leaveProcessDtoRequest),
					LeaveRequestAction.REAPPLIED, userService.findUserById(leaveProcessDtoRequest.getProcessedBy()),leaveProcessDtoRequest.getLeaveRequest()),
					HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
