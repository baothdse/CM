package com.cm.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cm.constants.ErrorConstants;
import com.cm.entities.MovieEntity;
import com.cm.entities.ScheduleEntity;
import com.cm.error.CustomError;
import com.cm.repositories.ScheduleRepository;
import com.cm.services.interfaces.MovieService;
import com.cm.services.interfaces.ScheduleService;

/**
 * @author BaoTHD
 *
 */
@Service
@Transactional
public class ScheduleServiceImp implements ScheduleService {

	@Autowired
	private ScheduleRepository scheduleRepository;

	@Override
	public List<ScheduleEntity> getScheduleByMovie(Long movieID) {
		java.util.Date today = new java.util.Date();
		java.util.Date tomorrow = new java.util.Date(today.getTime() + 7*(1000 * 60 * 60 * 24));
		java.sql.Date todaySql = new java.sql.Date(today.getTime());
		java.sql.Date tomorrowSql = new java.sql.Date(tomorrow.getTime());
		return (List<ScheduleEntity>) scheduleRepository.findByMovie(movieID, todaySql, tomorrowSql);
	}

	@Override
	public ScheduleEntity getScheduleByScheduleId(Long scheduleId) {
		// TODO Auto-generated method stub
		return scheduleRepository.findByScheduleId(scheduleId);
	}

	@Autowired
	private MovieService movieService;
	
	/* 
	 * @author: BaoTHD
	 */
	@Override
	public boolean createSchedule(Long movieId, String startDate, String startTime, String theatre, 
									int room, List<ScheduleEntity> listOfSchedule, long lenght, CustomError error) throws ParseException {
	
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
		Date time = new SimpleDateFormat("HH:mm").parse(startTime);

		long cleanedTime = 10;
		long timeOfOneSlot = (lenght + cleanedTime) * 60000;
		List<ScheduleEntity> scheduleListOfOneRoom = scheduleRepository.findByTheatreAndRoomAndStartDate(theatre, room, date); 
		boolean checkDuplicated = true;
		
		if (scheduleListOfOneRoom.isEmpty()) {
			createScheduleByMovieId(movieId, date, time, theatre, room, listOfSchedule);
			return true;
		} else {
			for (int index = 0; index < scheduleListOfOneRoom.size(); index++) {
				if (time.after(scheduleListOfOneRoom.get(index).getStartTime())) {
					if ((time.getTime() - timeOfOneSlot) < scheduleListOfOneRoom.get(index).getStartTime().getTime()) {
						checkDuplicated = false;
						error.setErrorCode(ErrorConstants.ER0010);
						error.setMessage(ErrorConstants.EM0010);
					} 
				} else if (time.before(scheduleListOfOneRoom.get(index).getStartTime())) {					
					if ((time.getTime() + timeOfOneSlot) > scheduleListOfOneRoom.get(index).getStartTime().getTime()) {
						checkDuplicated = false;
						error.setErrorCode(ErrorConstants.ER0010);
						error.setMessage(ErrorConstants.EM0010);
					}
				} else if (time.equals(scheduleListOfOneRoom.get(index).getStartTime())) {
					checkDuplicated = false;
					error.setErrorCode(ErrorConstants.ER004);
					error.setMessage(ErrorConstants.EM004);
				}
			}
			if (checkDuplicated == true) {
				createScheduleByMovieId(movieId, date, time, theatre, room, listOfSchedule);
				return true;
			} else {
				return false;
			}
		}
		
	}
	
	@Override
	public void createScheduleByMovieId(Long movieId, Date startDate, Date startTime, String theatre, 
									int room, List<ScheduleEntity> lisftOfSchedule) {
		MovieEntity movie = movieService.getMovieByMovieId(movieId);
		ScheduleEntity schedule = new ScheduleEntity();

		schedule.setMovie(movie);
		schedule.setStartDate(startDate);
		schedule.setStartTime(startTime);
		schedule.setTheatre(theatre);
		schedule.setRoom(room);
		schedule.setIsActive(true);
		scheduleRepository.save(schedule);
		lisftOfSchedule.add(schedule);
	}

	/* 
	 * @author: BaoTHD
	 */
	@Override
	public List<ScheduleEntity> getAllSchedules() {
		return scheduleRepository.findAll();
	}
	
	/* 
	 * @author: BaoTHD
	 */
	@Override
	public List<ScheduleEntity> getScheduleByMovieId(Long movieId) {
		return (List<ScheduleEntity>) scheduleRepository.findByMovie(movieId);
	}

	
	/* 
	 * @author: BaoTHD
	 */
	@Override
	public boolean changeScheduleState(ScheduleEntity schedule) {
		// TODO Auto-generated method stub
		if  (schedule.getIsActive() == true) {
			schedule.setIsActive(false);
			scheduleRepository.setFixedScheduleFor(schedule.getIsActive(), schedule.getScheduleId());
			return true;
		} 
		return false;
	}
	
	

}
