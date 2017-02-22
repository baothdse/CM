package com.cm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cm.entities.MovieEntity;
import com.cm.services.interfaces.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	MovieService movieService;

	@RequestMapping(value = "/comingSoon", method = RequestMethod.GET)
	public ResponseEntity<?> getComingSoon() {
		List<MovieEntity> movie = (List<MovieEntity>) movieService.getMovieComingSoon();
		return new ResponseEntity<List<MovieEntity>>(movie, HttpStatus.OK);
	}

	@RequestMapping(value = "/moviePresenting", method = RequestMethod.GET)
	public ResponseEntity<?> getMoviePresenting() {
		List<MovieEntity> movie = (List<MovieEntity>) movieService.getMoviePresenting();
		return new ResponseEntity<List<MovieEntity>>(movie, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllMovie", method = RequestMethod.GET)
	public ResponseEntity<?> getAllMovie() {
		List<MovieEntity> movie = (List<MovieEntity>) movieService.getAllMovie();
		return new ResponseEntity<List<MovieEntity>>(movie, HttpStatus.OK);
	}
}
