package com.cm.controller;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.omg.CORBA.ServerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cm.entity.AccountEntity;
import com.cm.entity.MovieEntity;
import com.cm.error.ErrorCustome;
import com.cm.services.interfaces.AccountService;
import com.cm.services.interfaces.MovieService;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	MovieService movieService;
	
//	@RequestMapping(value = "/comingSoon", method = RequestMethod.GET)
//	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id", scope=ServerRequest.class)
//	@ManyToOne(fetch = FetchType.EAGER)
	public MovieEntity getComingSoon() {
		MovieEntity movie = movieService.getMovieComingSoon();
		System.out.println(movie);
		return movie; 

	}	
}
