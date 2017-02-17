package com.cm.controller;

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
		MovieEntity movie = movieService.getMovieComingSoon();
		System.out.println(movie);
		return new ResponseEntity<MovieEntity>(movie, HttpStatus.OK); 
	}	
}
