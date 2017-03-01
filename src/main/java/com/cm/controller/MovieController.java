package com.cm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cm.constants.ErrorConstants;
import com.cm.constants.ParamConstants;
import com.cm.constants.URLConstants;
import com.cm.entities.MovieEntity;
import com.cm.error.CustomError;
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
	
	@RequestMapping(value = "/changeMovieState", method = RequestMethod.POST)
	public ResponseEntity<?> changeMovieState(@RequestParam(value = ParamConstants.MOVIE_ID) Long movieId) {
		MovieEntity movie = movieService.getMovieByMovieId(movieId);
		CustomError error = new CustomError(ErrorConstants.ER006, ErrorConstants.EM006);
		if(movieService.changeMovieState(movie) == true) {
			return new ResponseEntity<MovieEntity>(movie, HttpStatus.OK);
		}
		return new ResponseEntity<CustomError>(error, HttpStatus.OK);
	}
}
