package com.cm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cm.constants.ParamConstants;
import com.cm.entities.ScheduleEntity;
import com.cm.services.interfaces.ScheduleService;

@RestController
@RequestMapping
public class ScheduleController {
	@Autowired 
	private ScheduleService scheduleService;
	
	@RequestMapping(value = "/schedules", method = RequestMethod.GET)
	public ResponseEntity<?> getScheduleByScheduleId(@RequestParam(value=ParamConstants.SCHEDULE_ID) Long scheduleId) {
    	
		ScheduleEntity schedule = scheduleService.getScheduleByScheduleId(scheduleId);
		//System.out.println(listOfSeat);
		return new ResponseEntity<ScheduleEntity>(schedule, HttpStatus.OK); 
	
    }	
}
