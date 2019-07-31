package com.invicta.lms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invicta.lms.dto.LeaveManagerDtoRequest;
import com.invicta.lms.dto.LeaveManagerDtoResponse;
import com.invicta.lms.dto.LeaveSummary;
import com.invicta.lms.dto.mapper.LeaveManagerMapper;
import com.invicta.lms.entity.LeaveManager;
import com.invicta.lms.repository.LeaveManagerRepository;
import com.invicta.lms.repository.UserRepository;
import com.invicta.lms.service.LeaveManagerService;


@Service
public class LeaveManagerServiceImpl implements LeaveManagerService {

	@Autowired
	LeaveManagerMapper leaveManagerMapper;

	@Autowired
	LeaveManagerRepository leaveManagerRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public LeaveManagerDtoResponse addLeaveManager(Long userid, LeaveManagerDtoRequest leaveManagerDtoRequest) {
		LeaveManager newleaveManager = new LeaveManager();
		LeaveManager leaveManager = leaveManagerMapper.mapDtoToEntity(leaveManagerDtoRequest, newleaveManager);
		if (leaveManager != null) {
			leaveManager.setUser(userRepository.findUserById(userid));
			LeaveManager repoleaveManager= leaveManagerRepository.save(leaveManager);
			return leaveManagerMapper.mapEntityToDto(repoleaveManager);
		}
		return null;
	}

	@Override
	public LeaveManagerDtoResponse updateLeaveManager(Long id, LeaveManagerDtoRequest leaveManagerDtoRequest) {
		if (leaveManagerRepository.getOne(id) != null) {
			LeaveManager editleaveManager = leaveManagerRepository.findLeaveManagerById(id);
			LeaveManager leaveManager = leaveManagerMapper.mapDtoToEntity(leaveManagerDtoRequest, editleaveManager);
			LeaveManager repoleaveManager= leaveManagerRepository.save(leaveManager);
			return leaveManagerMapper.mapEntityToDto(repoleaveManager);
		}
		return null;
	}

	@Override
	public LeaveManagerDtoResponse findLeaveManagerById(Long id) {
		if (leaveManagerRepository.getOne(id) != null) {
			return leaveManagerMapper.mapEntityToDto(leaveManagerRepository.findLeaveManagerById(id));
		}
		return null;
	}

	@Override
	public Long deleteLeaveManagerById(Long id) {
		if (leaveManagerRepository.getOne(id) != null) {
			leaveManagerRepository.deleteById(id);
			return id;
		}
		return null;
	}

	@Override
	public List<LeaveManagerDtoResponse>  findAllLeaveManager() {
		return leaveManagerMapper.mapEntityToDtoList(leaveManagerRepository.findAll());
	}

	@Override
	public List<LeaveManagerDtoResponse> findLeaveManagerByUserId(Long userId) {
		return leaveManagerMapper.mapEntityToDtoList(leaveManagerRepository.findLeaveManagerByUserId(userId));
	}

	@Override
	public List<LeaveManagerDtoResponse> findLeaveManagerByUserAndLeaveType(Long userId, Long leaveTypeId) {
		return leaveManagerMapper.mapEntityToDtoList(leaveManagerRepository.findLeaveManagerByUserAndLeaveType(userId, leaveTypeId));
	}

	@Override
	public LeaveSummary leaveSummary(Long userId, Long leaveTypeId) {
//		LeaveSummary leaveSummary = new LeaveSummary();
//		leaveSummary.setLeaveType(leaveTypeService.findLeaveTypeById(leaveTypeId).getLeaveTypeName());
//
//		leaveSummary.setAllocation(leaveDaysProcessorRepository.sumLeaveProcessTypesByUserandLeaveType(userId,
//				leaveTypeId, LeaveProcessType.ALLOCATION));
//		leaveSummary.setUtilized(leaveDaysProcessorRepository.sumLeaveProcessTypesByUserandLeaveType(userId,
//				leaveTypeId, LeaveProcessType.UTILIZED));
//		leaveSummary.setRemaining(leaveDaysProcessorRepository.sumLeaveDaysByUserAndLeaveType(userId, leaveTypeId));
//		return leaveSummary;
		return null;
	}

}
