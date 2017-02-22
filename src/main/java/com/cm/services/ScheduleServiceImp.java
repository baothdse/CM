package com.cm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cm.entities.ScheduleEntity;
import com.cm.repositories.ScheduleRepository;
import com.cm.services.interfaces.ScheduleService;

@Service
@Transactional
public class ScheduleServiceImp implements ScheduleService {

	@Autowired
	ScheduleRepository scheduleRepository;

	@Override
	public List<ScheduleEntity> getScheduleByMovie(Long movieID) {
		java.util.Date today = new java.util.Date();
		java.util.Date tomorrow = new java.util.Date(today.getTime() + (1000 * 60 * 60 * 24));
		java.sql.Date todaySql = new java.sql.Date(today.getTime());
		java.sql.Date tomorrowSql = new java.sql.Date(tomorrow.getTime());
		return (List<ScheduleEntity>) scheduleRepository.findByMovie(movieID, todaySql, tomorrowSql);
	}

	@Override
	public ScheduleEntity getScheduleByScheduleId(Long scheduleId) {
		// TODO Auto-generated method stub
		return scheduleRepository.findByScheduleId(scheduleId);
	}
}
