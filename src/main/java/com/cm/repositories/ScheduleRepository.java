package com.cm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cm.entities.ScheduleEntity;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long> {
	
	ScheduleEntity findByScheduleId(Long scheduleId);
}
