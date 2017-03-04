package com.cm.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cm.entities.MovieEntity;

public interface MovieRepository extends JpaRepository<MovieEntity, Long> {

	@Query("SELECT t FROM MovieEntity t WHERE :nowDate < t.startDate")
	List<MovieEntity> findByStartDate(@Param("nowDate") Date nowDate);

	@Query("SELECT t FROM MovieEntity t WHERE :nowMovie >= t.startDate and :nowMovie <= t.endDate")
	List<MovieEntity> findByStartEndDate(@Param("nowMovie") Date nowMovie);
	
	MovieEntity findByMovieId(Long movieId);
	
	/**
	 * @author BaoTHD
	 * @param isActive
	 * @param movieId
	 */
	@Modifying
	@Query("Update MovieEntity m set m.isActive = :isActive where m.isActive = true and m.movieId = :movieId")
	void setFixedMovieFor(@Param("isActive") boolean isActive, @Param("movieId") Long movieId );
	
	@Modifying
	@Query("Update MovieEntity m set m.movieName = :movieName, m.introduction = :introduction, m.actor = :actor, "
			+ "m.genre = :genre, m.startDate = :startDate, m.endDate = :endDate, m.trailer = :trailer, "
			+ "m.picture = :picture, m.lenght = :lenght where m.movieId = :movieId" )
	void setFixedMovieFor(@Param("movieName") String movieName, @Param("introduction") String introduction,
			@Param("actor") String actor, @Param("genre") String genre, @Param("startDate") Date startDate, 
			@Param("endDate") Date endDate, @Param("trailer") String trailer, @Param("picture") String picture, 
			@Param("lenght") int lenght, @Param("movieId") Long movieId);
}
