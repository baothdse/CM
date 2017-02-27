package com.cm.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
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
			+ "(s.startDate >= :today and s.startDate <= :tomorow)")
	List<ScheduleEntity> findByMovie(@Param("movieID") Long movieID, @Param("today") Date today,
			@Param("tomorow") Date tomorow);

	ScheduleEntity findByScheduleId(Long scheduleId);
	
	@Query("Select s from ScheduleEntity s, MovieEntity m where s.movie.movieId = :movieId and m.movieId = :movieId ")
	List<ScheduleEntity> findByMovie(@Param("movieId") Long movieId);
}
