package com.cm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cm.entities.SeatEntity;
import com.cm.repositories.SeatRepository;
import com.cm.services.interfaces.SeatService;

@Service
@Transactional
public class SeatServiceImp implements SeatService {
	
	@Autowired
	private SeatRepository seatRepository;
	
	@Override
	public List<SeatEntity> getListOfSeatBySchedule(Long scheduleId) {
		// TODO Auto-generated method stub
		return (List<SeatEntity>) seatRepository.findBySchedules(scheduleId);
	}

}
