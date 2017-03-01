package com.cm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cm.constants.ParamConstants;
import com.cm.entities.SeatEntity;

public interface SeatRepository extends JpaRepository<SeatEntity, Long> {

	@Query("SELECT s FROM SeatEntity s, ScheduleEntity sc WHERE s.schedules.scheduleId = :scheduleId and "
			+ "sc.scheduleId = :scheduleId")
	List<SeatEntity> findBySchedules(@Param(value = ParamConstants.SCHEDULE_ID) Long scheduleId);
	
	SeatEntity findBySeatId(Long seatId);

	@Modifying
	@Query("Update SeatEntity s set s.seatStatus = :seatStatus where s.seatStatus = false and s.seatId = :seatId")
	void setFixedSeatStatusFor(@Param("seatStatus") boolean seatStatus, @Param("seatId") Long seatId);
}
