package com.cm.services.interfaces;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.cm.entities.ScheduleEntity;
import com.cm.error.CustomError;

public interface ScheduleService {
	List<ScheduleEntity> getScheduleByMovie(Long movieID);

	ScheduleEntity getScheduleByScheduleId(Long scheduleId);

	boolean createSchedule(Long movieId, String startDate, String startTime, String theatre, 
									int room, List<ScheduleEntity> listOfSchedule, long lenght, CustomError error) throws ParseException;
	
	List<ScheduleEntity> getAllSchedules();

	List<ScheduleEntity> getScheduleByMovieId(Long movieId);
	
	boolean changeScheduleState(ScheduleEntity schedule);

	void createScheduleByMovieId(Long movieId, Date startDate, Date startTime, String theatre, int room,
			List<ScheduleEntity> lisftOfSchedule);
}
