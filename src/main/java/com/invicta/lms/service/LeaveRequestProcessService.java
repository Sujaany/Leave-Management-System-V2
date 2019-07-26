package com.invicta.lms.service;

import com.invicta.lms.entity.LeaveRequest;
import com.invicta.lms.entity.LeaveRequestProcess;
import com.invicta.lms.entity.User;
import com.invicta.lms.enums.LeaveRequestAction;

public interface LeaveRequestProcessService {
	Boolean createLeaveRequestProcess(LeaveRequestProcess leaveRequestProcess,LeaveRequest leaveRequest,User user);
	Boolean processLeaveRequest(LeaveRequestProcess leaveRequestProcess,LeaveRequestAction leaveRequestAction,User user,Long lid);
}
