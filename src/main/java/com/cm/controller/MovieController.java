package com.cm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cm.constants.URLConstants;
import com.cm.entities.MovieEntity;
import com.cm.services.interfaces.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	MovieService movieService;

	@RequestMapping(value = URLConstants.GET_MOVIE_SOON, method = RequestMethod.GET)
	public ResponseEntity<?> getComingSoon() {
		List<MovieEntity> movie = (List<MovieEntity>) movieService.getComingSoonMovie();
		System.out.println(movie);
		return new ResponseEntity<List<MovieEntity>>(movie, HttpStatus.OK);
	}

	@RequestMapping(value = URLConstants.GET_MOVIE_NOW, method = RequestMethod.GET)
	public ResponseEntity<?> getMoviePresenting() {

		List<MovieEntity> movie = (List<MovieEntity>) movieService.getPresentingMovie();
		return new ResponseEntity<List<MovieEntity>>(movie, HttpStatus.OK);
	}
	
	/**
	 * @author BaoTHD
	 * @return
	 */
	@RequestMapping(value = URLConstants.GET_ALL_MOVIE, method = RequestMethod.GET)
	public ResponseEntity<?> getAllMovie() {
		List<MovieEntity> movie = movieService.getAllMovie();
		return new ResponseEntity<List<MovieEntity>>(movie, HttpStatus.OK);
	}
	
//	@RequestMapping(value = "/all-movie", method = RequestMethod.GET)
//	public ResponseEntity<?> getAllMovie() {
//		List<MovieEntity> allMovie = movieService.getAllMovie();
//		return new ResponseEntity<List<MovieEntity>>(allMovie, HttpStatus.OK);
//	}
}
