package com.cm.services.interfaces;

import java.util.List;

import com.cm.entities.SeatEntity;

public interface SeatService {

	List<SeatEntity> getListOfSeatBySchedule(Long scheduleId);
}
