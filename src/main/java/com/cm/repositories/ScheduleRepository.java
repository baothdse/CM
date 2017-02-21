package com.cm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cm.entities.ScheduleEntity;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long> {
	@Query("SELECT sc FROM SeatEntity s, ScheduleEntity sc WHERE s.schedules.scheduleId = :scheduleId and "
			+ "sc.scheduleId = :scheduleId")
	ScheduleEntity findByScheduleId(Long scheduleId);
}
