package com.invicta.lms.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.invicta.lms.enums.LeaveProcessType;

@Entity
@Table(name="leave_days_processor",schema="leave_system")
public class LeaveDaysProcessor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable =false)
	private User user_id;
	
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name="leave_type_id", nullable =false)
	private LeaveType leaveType;
	
	@Enumerated(EnumType.STRING)
	private LeaveProcessType leaveProcessType;
	
	private Double Days;
	private Date Date_of_process;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser_id() {
		return user_id;
	}
	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}
	public LeaveType getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(LeaveType leaveType) {
		this.leaveType = leaveType;
	}
	public LeaveProcessType getLeaveProcessType() {
		return leaveProcessType;
	}
	public void setLeaveProcessType(LeaveProcessType leaveProcessType) {
		this.leaveProcessType = leaveProcessType;
	}
	public Double getDays() {
		return Days;
	}
	public void setDays(Double days) {
		Days = days;
	}
	public Date getDate_of_process() {
		return Date_of_process;
	}
	public void setDate_of_process(Date date_of_process) {
		Date_of_process = date_of_process;
	} 
}
