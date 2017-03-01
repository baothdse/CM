package com.cm.services.interfaces;

import java.util.List;

import com.cm.entities.MovieEntity;

public interface MovieService {
	
      List<MovieEntity> getComingSoonMovie();
	  List<MovieEntity> getPresentingMovie();
	  List<MovieEntity> getAllMovie();
	  MovieEntity getMovieByMovieId(Long movieId);
	  
	  boolean changeMovieState(MovieEntity movie);

}
