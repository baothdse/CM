package com.cm.services.interfaces;

import java.util.Date;
import java.util.List;

import com.cm.entities.MovieEntity;

public interface MovieService {

      List<MovieEntity> getComingSoonMovie();

	  List<MovieEntity> getPresentingMovie();
	  
	  List<MovieEntity> getAllMovie();
	  
	  MovieEntity getMovieByMovieId(Long movieId);
	  
	  List<MovieEntity> getMovieByUserId(Long userID);
	  
	  void saveMovie(MovieEntity movie);
	  
	  boolean changeMovieState(MovieEntity movie);
	  
	  void updateMovie(MovieEntity movie, String movieName, String introduction, String actor, String genre,
				Date startDate, Date endDate, String trailer, String picture, int lenght);
	  
	  void createMovieByUserId(Long userID, String movieName, String introduction, String actor, String genre,
			Date startDate, Date endDate, String trailer, String picture, Integer lenght,
			List<MovieEntity> listOfMovie);
}
