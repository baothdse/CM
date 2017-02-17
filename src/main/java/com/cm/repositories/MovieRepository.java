package com.cm.repositories;



import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cm.entities.MovieEntity;

public interface MovieRepository extends JpaRepository<MovieEntity, Long>{
    
	@Query("SELECT t FROM MovieEntity t WHERE :nowDate <= t.startDate")
	MovieEntity findByStartDate(@Param("nowDate") Date nowDate);
}
