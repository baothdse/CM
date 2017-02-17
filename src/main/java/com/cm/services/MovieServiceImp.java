package com.cm.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cm.entities.MovieEntity;
import com.cm.repositories.MovieRepository;
import com.cm.services.interfaces.MovieService;

@Service
@Transactional
public class MovieServiceImp  implements MovieService{

	@Autowired
	MovieRepository movieRepository;
	
	@Override
	public MovieEntity getMovieComingSoon() {
		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date( date.getTime() );
		return movieRepository.findByStartDate(sqlDate);
	}

}
