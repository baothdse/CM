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

	@RequestMapping(value = "/schedules", method = RequestMethod.GET)
	public ResponseEntity<?> getScheduleByScheduleId(
			@RequestParam(value = ParamConstants.SCHEDULE_ID) Long scheduleId) {

		ScheduleEntity schedule = scheduleService.getScheduleByScheduleId(scheduleId);
		// System.out.println(listOfSeat);
		return new ResponseEntity<ScheduleEntity>(schedule, HttpStatus.OK);

	}

	@RequestMapping(value = "/create-schedule", method = RequestMethod.POST)
	public ResponseEntity<?> createScheduleByMovie(@RequestParam(value = "movieId") Long movieId,
													@RequestParam(value = "startDate") String startDate, 
													@RequestParam(value = "startTime") String startTime,
													@RequestParam(value = "theatre") String theatre, 
													@RequestParam(value = "room") int room) throws ParseException {
		List<ScheduleEntity> listOfSchedule = scheduleService.getAllSchedules();
		for (int i = 0; i < listOfSchedule.size(); i++) {
			System.out.println("List of schedule" + listOfSchedule.get(i).getTheatre());
		}
		
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
		Date time = new SimpleDateFormat("hh:mm:ss").parse(startTime);
		 
		if (listOfSchedule.isEmpty()) {
			scheduleService.createScheduleByMovieId(movieId, date, time, theatre, room);
			Long scheduleId = listOfSchedule.get(listOfSchedule.size() - 1).getScheduleId();
			seatService.createSeatByScheduleId(scheduleId);
			return new ResponseEntity<List<ScheduleEntity>>(listOfSchedule, HttpStatus.OK);
		} else {
			for (ScheduleEntity schedule : listOfSchedule) {
				if (schedule.getTheatre() == theatre && schedule.getRoom() == room
						&& schedule.getStartDate() == date && schedule.getStartTime() == time) {
					System.out.println("Debug" + schedule.getTheatre());
					CustomError error = new CustomError(ErrorConstants.ER004, ErrorConstants.EM004);
					return new ResponseEntity<CustomError>(error, HttpStatus.OK);
				} else {
					scheduleService.createScheduleByMovieId(movieId, date, time, theatre, room);
					Long scheduleId = listOfSchedule.get(listOfSchedule.size() - 1).getScheduleId();
					seatService.createSeatByScheduleId(scheduleId);
					return new ResponseEntity<List<ScheduleEntity>>(listOfSchedule, HttpStatus.OK);
				}
			}
		}
		return new ResponseEntity<List<ScheduleEntity>>(listOfSchedule, HttpStatus.OK);
	}

	@RequestMapping(value = "/getShowtime", method = RequestMethod.POST)
	public ResponseEntity<?> getComingSoon(@RequestParam(value = ParamConstants.MOVIE_ID) Long movieID) {
		List<ScheduleEntity> schedule = (List<ScheduleEntity>) scheduleService.getScheduleByMovie(movieID);
		return new ResponseEntity<List<ScheduleEntity>>(schedule, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAllSchedule", method = RequestMethod.GET)
	public ResponseEntity<?> getAllSchedule() {
		List<ScheduleEntity> listOfSchedule = scheduleService.getAllSchedules();
		return new ResponseEntity<List<ScheduleEntity>>(listOfSchedule, HttpStatus.OK);
	}

}
