package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.demo.Enum.LeaveRequestTrackType;

@Entity
public class LeaveRequestTrack {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private LeaveRequestTrackType leaveRequestTrackType;
	
	@ManyToOne
	private LeaveRequest leaveRequest;
	
	@ManyToOne
	@JoinColumn(name = "process_by")
	private User processedBy;
	
	private String reason;
	private Date createdTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LeaveRequestTrackType getLeaveRequestTrackType() {
		return leaveRequestTrackType;
	}
	public void setLeaveRequestTrackType(LeaveRequestTrackType leaveRequestTrackType) {
		this.leaveRequestTrackType = leaveRequestTrackType;
	}
	public LeaveRequest getLeaveRequest() {
		return leaveRequest;
	}
	public void setLeaveRequest(LeaveRequest leaveRequest) {
		this.leaveRequest = leaveRequest;
	}
	public User getProcessedBy() {
		return processedBy;
	}
	public void setProcessedBy(User processedBy) {
		this.processedBy = processedBy;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	
}
