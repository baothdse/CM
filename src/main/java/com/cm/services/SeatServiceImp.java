package com.cm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cm.constants.ParamConstants;
import com.cm.entities.ScheduleEntity;
import com.cm.entities.SeatEntity;
import com.cm.repositories.SeatRepository;
import com.cm.services.interfaces.ScheduleService;
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

	@Override
	public void saveSeat(SeatEntity seat) {
		// TODO Auto-generated method stub
		seatRepository.save(seat);
	}

	@Autowired
	private ScheduleService scheduleService;

	@Override
	public void createSeatByScheduleId(Long scheduleId) {
		// TODO Auto-generated method stub
		List<SeatEntity> listOfSeat = seatRepository.findBySchedules(scheduleId);
		ScheduleEntity schedule = scheduleService.getScheduleByScheduleId(scheduleId);

		for (int index = 0; index < 50; index++) {
			SeatEntity seat = new SeatEntity();
			seat.setSeatName(ParamConstants.LIST_OF_SEAT[index]);
			seat.setSeatStatus(false);
			seat.setSchedules(schedule);
			saveSeat(seat);
			listOfSeat.add(seat);
			System.out.println(listOfSeat.get(index).getSeatName());
		}

	}

}
