package com.invicta.lms.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invicta.lms.entity.LieuLeaveRequest;
import com.invicta.lms.entity.User;
import com.invicta.lms.exception.AppException;
import com.invicta.lms.exception.ResourceNotFoundException;
import com.invicta.lms.repository.LieuLeaveRequestRepository;
import com.invicta.lms.service.LieuLeaveRequestService;

@Service
public class LieuLeaveRequestServiceImpl implements LieuLeaveRequestService {
	@Autowired
	LieuLeaveRequestRepository lieuLeaveRequestRepository;

	private static final Logger logger = LoggerFactory.getLogger(LieuLeaveRequestServiceImpl.class);

	@Override
	public LieuLeaveRequest applyLeieuLeave(LieuLeaveRequest lieuLeaveRequest, User user) {
		try {
			logger.info("LieuLeaveRequest creating");
			if (lieuLeaveRequest != null) {
				lieuLeaveRequest.setUserId(user);
				return lieuLeaveRequestRepository.save(lieuLeaveRequest);
			}

		} catch (Exception e) {
			logger.error("LieuLeaveRequest Not Creating at the time", e.fillInStackTrace());
			throw new AppException("LieuLeaveRequest Not Creating", e.fillInStackTrace());
		}
		return null;
	}

	@Override
	public List<LieuLeaveRequest> viewAllLieuLeaveRequest() {
		try {
			return lieuLeaveRequestRepository.findAll();

		} catch (Exception e) {
			throw new AppException("LieuLeaveRequest Not Get", e.getCause());
		}
	}

	@Override
	public Long deleteLieuLeaveRequest(Long id) {
		try {
			if (lieuLeaveRequestRepository.getOne(id) != null) {
				logger.info("---------------------LieuLeaveRequest deleted-------------------");
				lieuLeaveRequestRepository.deleteById(id);
				return id;
			}

		} catch (Exception e) {
			logger.error("---------------LieuLeaveRequest id is  not found ---------------", e.fillInStackTrace());
			throw new ResourceNotFoundException("Id is", "id", id);
		}
		return null;

	}

	@Override
	public LieuLeaveRequest updateLieuLeaveRequest(Long id, LieuLeaveRequest lieuLeaveRequest, User user) {
		try {
			logger.info("---------------------LieuLeaveRequest Update-------------------");
			if (lieuLeaveRequestRepository.getOne(id) != null) {
				lieuLeaveRequest.setId(id);
				lieuLeaveRequest.setUserId(user);
				return lieuLeaveRequestRepository.save(lieuLeaveRequest);

			}

		} catch (Exception e) {
			logger.error("---------------LieuLeaveRequest UPDATE ID is  not found ---------------",
					e.fillInStackTrace());
			throw new ResourceNotFoundException("LieuLeaveRequest UPDATE Id is", "id", id);
		}
		return null;
	}

	@Override
	public LieuLeaveRequest findLieuLeaveRequestById(Long id) {
		try {
			logger.info("---------------------LieuLeaveRequest Find Lieu Leave Request By Id-------------------");
			if (lieuLeaveRequestRepository.getOne(id) != null) {
				return lieuLeaveRequestRepository.findLieuLeaveRequestById(id);
			}
		} catch (Exception e) {
			logger.error("---------------------LieuLeaveRequest Find Lieu Leave Request By Id-------------------",
					e.fillInStackTrace());
			throw new ResourceNotFoundException("LieuLeaveRequest Find Lieu Leave Request By Id", "LieuLeaveRequest",
					id);
		}

		return null;
	}

	@Override
	public List<LieuLeaveRequest> findByUser(Long id) {
		logger.info("---------------------LieuLeaveRequest Find by User Id-------------------");
		try {
			return lieuLeaveRequestRepository.findByUser(id);

		} catch (Exception e) {
			logger.error("---------------LieuLeaveRequest Find by User Id- ID is  not found ---------------",
					e.fillInStackTrace());
			throw new ResourceNotFoundException("LieuLeaveRequest Find by User Id", "userId", id);
		}
	}

}
