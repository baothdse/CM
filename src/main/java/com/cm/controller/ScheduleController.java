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
import com.cm.entities.ScheduleEntity;
import com.cm.services.interfaces.ScheduleService;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

	@Autowired
	ScheduleService scheduleService;
	
	@RequestMapping(value = "/getShowtime", method = RequestMethod.POST)
	public ResponseEntity<?> getComingSoon(@RequestParam(value=ParamConstants.MOVIE_ID) Long movieID) {
		List<ScheduleEntity> schedule = (List<ScheduleEntity>) scheduleService.getScheduleByMovie(movieID);
		return new ResponseEntity<List<ScheduleEntity>>(schedule, HttpStatus.OK); 
	}	
}
