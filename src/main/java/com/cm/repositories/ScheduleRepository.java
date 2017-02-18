package com.cm.repositories;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.cm.entities.ScheduleEntity;


public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long>{
	
	@Query("Select s from ScheduleEntity s where s.movie.movieId = :movieID and "
			+ "(s.startDate = :today or s.startDate = :tomorow)")
	List<ScheduleEntity> findByMovie(@Param("movieID") Long movieID,@Param("today") Date today,@Param("tomorow") Date tomorow);
}
