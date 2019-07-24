package com.invicta.lms.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.invicta.lms.entity.LeaveDaysProcessor;
import com.invicta.lms.enums.LeaveProcessType;

public interface LeaveDaysProcessorRepository extends JpaRepository<LeaveDaysProcessor, Long> {

	LeaveDaysProcessor findLeaveDaysProcessorById(Long id);
		
	@Query("SELECT ld FROM LeaveDaysProcessor ld INNER JOIN ld.user u WHERE u.id=:userid")
	List<LeaveDaysProcessor> findLeaveDaysByUserId(@Param("userid") Long userid);
	
	@Query("SELECT ldp FROM LeaveDaysProcessor ldp INNER JOIN ldp.user u INNER JOIN ldp.leaveType lt WHERE u.id=:userid and lt.id=:leaveTypeid ")
	List<LeaveDaysProcessor> findLeaveDaysByUserAndLeaveType(@Param("userid") Long userid,@Param("leaveTypeid") Long leaveTypeid);
	
	@Query("SELECT  sum(ldp.days) FROM LeaveDaysProcessor ldp INNER JOIN ldp.user u INNER JOIN ldp.leaveType lt WHERE u.id=:userid and lt.id=:leaveTypeid ")
	Double sumLeaveDaysByUserAndLeaveType(@Param("userid") Long userid,@Param("leaveTypeid") Long leaveTypeid);
		
	@Query("SELECT  sum(ldp.days) FROM LeaveDaysProcessor ldp INNER JOIN ldp.user u INNER JOIN ldp.leaveType lt WHERE u.id=:userid and lt.id=:leaveTypeid and ldp.leaveProcessType=:leaveProcessTypeid ")
	Double sumLeaveProcessTypesByUserandLeaveType(@Param("userid") Long userid,@Param("leaveTypeid") Long leaveTypeid, @Param("leaveProcessTypeid") LeaveProcessType leaveProcessTypeid);
		
}

