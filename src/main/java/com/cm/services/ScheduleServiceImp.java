package com.cm.services;

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
	private ScheduleRepository scheduleRepository;
	
	@Override
	public ScheduleEntity getScheduleByScheduleId(Long scheduleId) {
		// TODO Auto-generated method stub
		return scheduleRepository.findOne(scheduleId);
	}

}
