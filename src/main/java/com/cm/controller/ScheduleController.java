package com.cm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cm.constants.ErrorConstants;
import com.cm.constants.ParamConstants;
import com.cm.constants.URLConstants;
import com.cm.entities.ScheduleEntity;
import com.cm.error.CustomError;
import com.cm.services.interfaces.ScheduleService;
import com.cm.services.interfaces.SeatService;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

	@Autowired
	private ScheduleService scheduleService;

	@Autowired
	private SeatService seatService;

	/**
	 * @author BaoTHD
	 * @param scheduleId
	 * @return
	 */
	@RequestMapping(value = "/schedules", method = RequestMethod.GET)
	public ResponseEntity<?> getScheduleByScheduleId(
			@RequestParam(value = ParamConstants.SCHEDULE_ID) Long scheduleId) {

		ScheduleEntity schedule = scheduleService.getScheduleByScheduleId(scheduleId);
		return new ResponseEntity<ScheduleEntity>(schedule, HttpStatus.OK);

	}

	/**
	 * @author BaoTHD
	 * @param movieId
	 * @param startDate
	 * @param startTime
	 * @param theatre
	 * @param room
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = URLConstants.CREATE_SCHEDULE_URL, method = RequestMethod.POST)
	public ResponseEntity<?> createScheduleByMovie(@RequestParam(value = "movieId") Long movieId,
													@RequestParam(value = ParamConstants.START_DATE) String startDate, 
													@RequestParam(value = ParamConstants.START_TIME) String startTime,
													@RequestParam(value = ParamConstants.THEATRE) String theatre, 
													@RequestParam(value = ParamConstants.ROOM) int room) throws ParseException {
		
		List<ScheduleEntity> listOfSchedule = scheduleService.getAllSchedules();
		ScheduleEntity scheduleEntity = null;
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
		Date time = new SimpleDateFormat("hh:mm").parse(startTime);
		boolean checkDuplicate = true;
		
		if (listOfSchedule.isEmpty()) {
			scheduleService.createScheduleByMovieId(movieId, date, time, theatre, room, listOfSchedule);
			Long scheduleId = listOfSchedule.get(listOfSchedule.size() -1).getScheduleId();
			seatService.createSeatByScheduleId(scheduleId);
			scheduleEntity = listOfSchedule.get(listOfSchedule.size() - 1);
		} else {
			CustomError error = new CustomError(ErrorConstants.ER004, ErrorConstants.EM004);
			for (ScheduleEntity schedule : listOfSchedule) {
				if (schedule.getTheatre().equals(theatre) && schedule.getRoom().equals(room)
						&& schedule.getStartDate().equals(date) && schedule.getStartTime().equals(time)) {						
					checkDuplicate = false;
				} else {
					checkDuplicate = true;
				}
			}	
			if (checkDuplicate == false) {
				return new ResponseEntity<CustomError>(error, HttpStatus.OK);
			} else {
				scheduleService.createScheduleByMovieId(movieId, date, time, theatre, room, listOfSchedule);
				Long scheduleId = listOfSchedule.get(listOfSchedule.size() - 1).getScheduleId();
				seatService.createSeatByScheduleId(scheduleId);
				scheduleEntity = listOfSchedule.get(listOfSchedule.size() - 1);
			}
		}
		return new ResponseEntity<ScheduleEntity>(scheduleEntity, HttpStatus.OK);
	}

	@RequestMapping(value = URLConstants.GET_SCHEDULE_MOVIE, method = RequestMethod.POST)
	public ResponseEntity<?> getComingSoon(@RequestParam(value = ParamConstants.MOVIE_ID) Long movieID) {
		List<ScheduleEntity> schedule = (List<ScheduleEntity>) scheduleService.getScheduleByMovie(movieID);
		return new ResponseEntity<List<ScheduleEntity>>(schedule, HttpStatus.OK);
	}

	
	@RequestMapping(value = "/changeScheduleState", method = RequestMethod.POST)
	public ResponseEntity<?> changeScheduleState(@RequestParam(value = ParamConstants.SCHEDULE_ID) Long scheduleId) {
		
		ScheduleEntity schedule = scheduleService.getScheduleByScheduleId(scheduleId);
		CustomError error = new CustomError(ErrorConstants.ER005, ErrorConstants.EM005);
		if (scheduleService.changeScheduleState(schedule) == true) {
			return new ResponseEntity<ScheduleEntity>(schedule, HttpStatus.OK);
		} else {
			return new ResponseEntity<CustomError>(error, HttpStatus.OK);
		}
		
	}
	/**
	 * @author BaoTHD
	 * @return
	 */
	@RequestMapping(value = "/getAllSchedule", method = RequestMethod.GET)
	public ResponseEntity<?> getAllSchedule() {
		List<ScheduleEntity> listOfSchedule = scheduleService.getAllSchedules();
		return new ResponseEntity<List<ScheduleEntity>>(listOfSchedule, HttpStatus.OK);
	}
	
	
}
	
