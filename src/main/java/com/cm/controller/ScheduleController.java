package com.cm.controller;

import java.text.ParseException;
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
import com.cm.services.interfaces.MovieService;
import com.cm.services.interfaces.ScheduleService;
import com.cm.services.interfaces.SeatService;

@RestController
@RequestMapping(value = URLConstants.SCHEDULE_URL)
public class ScheduleController {

	@Autowired
	private ScheduleService scheduleService;

	@Autowired
	private SeatService seatService;
	
	@Autowired
	private MovieService movieService;

	private ScheduleEntity schedule;

	/**
	 * @author BaoTHD
	 * @param scheduleId
	 * @return
	 */
	@RequestMapping(value = URLConstants.GET_MOVIE_BY_ID_URL, method = RequestMethod.GET)
	public ResponseEntity<?> getScheduleByScheduleId(
			@RequestParam(value = ParamConstants.SCHEDULE_ID) Long scheduleId) {

		schedule = scheduleService.getScheduleByScheduleId(scheduleId);
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
	public ResponseEntity<?> createScheduleByMovie(@RequestParam(value = ParamConstants.MOVIE_ID) Long movieId,
			@RequestParam(value = ParamConstants.START_DATE) String startDate,
			@RequestParam(value = ParamConstants.START_TIME) String startTime,
			@RequestParam(value = ParamConstants.THEATRE) String theatre,
			@RequestParam(value = ParamConstants.ROOM) int room) throws ParseException {

		CustomError error = new CustomError();
		List<ScheduleEntity> listOfSchedule = scheduleService.getAllSchedules();
		long lenght = movieService.getMovieByMovieId(movieId).getLenght();

		if (scheduleService.createSchedule(movieId, startDate, startTime, theatre, room, listOfSchedule, lenght, error) == true) {
			Long scheduleId = listOfSchedule.get(listOfSchedule.size() - 1).getScheduleId();
			seatService.createSeatByScheduleId(scheduleId);
			schedule = listOfSchedule.get(listOfSchedule.size() - 1);
			return new ResponseEntity<ScheduleEntity>(schedule, HttpStatus.OK);
		} else {
			return new ResponseEntity<CustomError>(error, HttpStatus.OK);
		}
	}

	@RequestMapping(value = URLConstants.GET_SCHEDULE_MOVIE, method = RequestMethod.POST)
	public ResponseEntity<?> getComingSoon(@RequestParam(value = ParamConstants.MOVIE_ID) Long movieID) {
		List<ScheduleEntity> listOfSchedule = (List<ScheduleEntity>) scheduleService.getScheduleByMovie(movieID);
		return new ResponseEntity<List<ScheduleEntity>>(listOfSchedule, HttpStatus.OK);
	}

	@RequestMapping(value = URLConstants.CHANGE_SCHEDULE_STATE_URL, method = RequestMethod.POST)
	public ResponseEntity<?> changeScheduleState(@RequestParam(value = ParamConstants.SCHEDULE_ID) Long scheduleId) {

		schedule = scheduleService.getScheduleByScheduleId(scheduleId);
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
	@RequestMapping(value = URLConstants.GET_ALL_SCHEDULE_URL, method = RequestMethod.GET)
	public ResponseEntity<?> getAllSchedule() {
		List<ScheduleEntity> listOfSchedule = scheduleService.getAllSchedules();
		return new ResponseEntity<List<ScheduleEntity>>(listOfSchedule, HttpStatus.OK);
	}

}
