package com.cm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cm.constants.ParamConstants;
import com.cm.constants.URLConstants;
import com.cm.entities.SeatEntity;
import com.cm.services.interfaces.SeatService;

@RestController
@RequestMapping
public class SeatController {

	@Autowired
	SeatService seatService;
	
    @RequestMapping(value = URLConstants.GET_SEAT_URL , method = RequestMethod.GET)
	public ResponseEntity<?> getSeatBySchedule(@RequestParam(value=ParamConstants.SCHEDULE_ID) Long scheduleId) {
		List<SeatEntity> listOfSeat = (List<SeatEntity>) seatService.getListOfSeatBySchedule(scheduleId);
		//System.out.println(listOfSeat);
		return new ResponseEntity<List<SeatEntity>>(listOfSeat, HttpStatus.OK); 
	}	
}
