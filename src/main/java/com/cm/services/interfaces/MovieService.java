package com.cm.services.interfaces;

import java.util.List;

import com.cm.entities.MovieEntity;

public interface MovieService {
	
      List<MovieEntity> getMovieComingSoon();
	  List<MovieEntity> getMoviePresenting();
	  List<MovieEntity> getAllMovie();
	  
	  List<MovieEntity> getMovieByUserId(Long userId);
	  void saveMovie(MovieEntity movie);
	  void createMovieByUserId(Long userId);
}
