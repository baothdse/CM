package com.cm.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cm.entities.ScheduleEntity;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long> {
	
	
	/**
	 * 
	 * @param movieID
	 * @param today
	 * @param tomorow
	 * @return
	 */
	@Query("Select s from ScheduleEntity s where s.movie.movieId = :movieID and "
			+ "(s.startDate >= :today and s.startDate <= :tomorow) and isActive != 0 order by s.startDate ASC, s.startTime")
	List<ScheduleEntity> findByMovie(@Param("movieID") Long movieID, @Param("today") Date today,
			@Param("tomorow") Date tomorow);

	
	/**
	 * @author BaoTHD
	 * @param scheduleId
	 * @return
	 */
	ScheduleEntity findByScheduleId(Long scheduleId);
	
	/**
	 * @author BaoTHD
	 * @param movieId
	 * @return
	 */
	@Query("Select s from ScheduleEntity s, MovieEntity m where s.movie.movieId = :movieId and m.movieId = :movieId ")
	List<ScheduleEntity> findByMovie(@Param("movieId") Long movieId);
	

	/**
	 * @param isActive
	 * @param scheduleId
	 */
	@Modifying
	@Query("Update ScheduleEntity s set s.isActive = :isActive where s.isActive = true and s.scheduleId = :scheduleId "
			+ "order by s.startTime ASC,")
	void setFixedScheduleFor(@Param("isActive") boolean isActive, @Param("scheduleId") Long scheduleId );
	
	
	@Query("Select s from ScheduleEntity s where s.theatre = :theatre and s.room = :room and s.startDate = :startDate")
	List<ScheduleEntity> findByTheatreAndRoomAndStartDate(@Param("theatre") String theatre, @Param("room") int room,
			@Param("startDate") Date startDate);
}
