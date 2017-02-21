package com.cm.services.interfaces;

import com.cm.entities.ScheduleEntity;

public interface ScheduleService {
	ScheduleEntity getScheduleByScheduleId(Long scheduleId);
}
