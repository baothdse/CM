package com.cm.services.interfaces;

import java.util.Date;
import java.util.List;

import com.cm.entities.ScheduleEntity;

public interface ScheduleService {
	List<ScheduleEntity> getScheduleByMovie(Long movieID);

	ScheduleEntity getScheduleByScheduleId(Long scheduleId);

	void createScheduleByMovieId(Long movieId, Date startDate, Date startTime, String theatre, 
									int room, List<ScheduleEntity> lisftOfSchedule);
	
	List<ScheduleEntity> getAllSchedules();

	List<ScheduleEntity> getScheduleByMovieId(Long movieId);
	
}
