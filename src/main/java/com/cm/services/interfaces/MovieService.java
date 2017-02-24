package com.cm.services.interfaces;

import java.util.List;

import com.cm.entities.MovieEntity;

public interface MovieService {
	
      List<MovieEntity> getMovieComingSoon();
	  List<MovieEntity> getMoviePresenting();
	  List<MovieEntity> getAllMovie();
	  
	  List<MovieEntity> getMovieBySchedule(Long scheduleId);
	  void saveMovie(MovieEntity movie);
	  void createMovieByScheduleId(Long scheduleId);
}
