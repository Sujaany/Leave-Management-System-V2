package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.LeaveType;
import com.example.demo.entity.User;
import com.example.demo.entity.UserLeaveCount;

public interface UserLeaveCountService {
	UserLeaveCount addUserLeaveCount(UserLeaveCount userLeaveCount);
	List<UserLeaveCount> viewAllUserLeaveCount();
	UserLeaveCount deleteUserLeaveCount(Integer id);
	UserLeaveCount updateUserLeaveCount(Integer id,UserLeaveCount userLeaveCount);
	UserLeaveCount findUserLeaveCountById(Integer id);
	UserLeaveCount findUserLeaveCountByUser(User user);
	UserLeaveCount findUserLeaveCountByUserANDLeaveType(User user,LeaveType leaveType);
	Double sumUserLeaveCountByUserLeaveType(User user,LeaveType leaveType);
}
