package com.cm.services.interfaces;
import java.util.List;

import com.cm.entities.ScheduleEntity;

public interface ScheduleService {  
	List<ScheduleEntity> getScheduleByMovie(Long movieID);
  ScheduleEntity getScheduleByScheduleId(Long scheduleId);

}
