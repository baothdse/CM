package com.cm.controller;

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
import com.cm.entities.SeatEntity;
import com.cm.error.CustomError;
import com.cm.services.interfaces.SeatService;

/**
 * @author BaoTHD
 *
 */
@RestController
@RequestMapping
public class SeatController {

	@Autowired
	private SeatService seatService;

	/**
	 * @author BaoTHD
	 * @param scheduleId
	 * @return
	 */
	@RequestMapping(value = URLConstants.GET_SEAT_URL, method = RequestMethod.GET)
	public ResponseEntity<?> getSeatBySchedule(@RequestParam(value = ParamConstants.SCHEDULE_ID) Long scheduleId) {

		List<SeatEntity> listOfSeat = (List<SeatEntity>) seatService.getListOfSeatBySchedule(scheduleId);
		// System.out.println(listOfSeat);
		return new ResponseEntity<List<SeatEntity>>(listOfSeat, HttpStatus.OK);

	}

//	@Autowired
//	private ScheduleService scheduleService;
//
//	@RequestMapping(value = "/schedule/create-seat", method = RequestMethod.POST)
//	public ResponseEntity<?> createSeat(@RequestParam(value = ParamConstants.SCHEDULE_ID) Long scheduleId) {
//		List<SeatEntity> listOfSeat = seatService.getListOfSeatBySchedule(scheduleId);
//
//		if (listOfSeat.isEmpty()) {
//			if (scheduleService.getScheduleByScheduleId(scheduleId) != null) {
//				seatService.createSeatByScheduleId(scheduleId);
//				return new ResponseEntity<List<SeatEntity>>(listOfSeat, HttpStatus.OK);
//			} else {
//				CustomError customError = new CustomError(ErrorConstants.ER003, ErrorConstants.EM003);
//				return new ResponseEntity<CustomError>(customError, HttpStatus.OK);
//			}
//		} else {
//			CustomError customError = new CustomError(ErrorConstants.ER002, ErrorConstants.EM002);
//			return new ResponseEntity<CustomError>(customError, HttpStatus.OK);
//		}
//	}
	
	/**
	 * @author BaoTHD
	 * @param seatId
	 * @return
	 */
	@RequestMapping(value = "/changeSeatStatus", method = RequestMethod.POST)
	public ResponseEntity<?> changeSeatStatus(@RequestParam(value = "seatId") Long seatId) {
		SeatEntity seatEntity = seatService.getSeatBySeatId(seatId);
		if (seatService.changeSeatState(seatEntity) == true) {
			return new ResponseEntity<SeatEntity>(seatEntity, HttpStatus.OK);
		} else {
			CustomError error = new CustomError(ErrorConstants.ER002, ErrorConstants.EM002);
			return new ResponseEntity<CustomError> (error, HttpStatus.OK);
		}
	}
}
