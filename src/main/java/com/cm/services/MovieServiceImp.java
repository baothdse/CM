package com.cm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cm.entities.MovieEntity;
import com.cm.entities.ScheduleEntity;
import com.cm.repositories.MovieRepository;
import com.cm.services.interfaces.MovieService;
import com.cm.services.interfaces.ScheduleService;

@Service
@Transactional
public class MovieServiceImp implements MovieService {

	@Autowired
	MovieRepository movieRepository;

	@Override
	public List<MovieEntity> getMovieComingSoon() {
		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		return (List<MovieEntity>) movieRepository.findByStartDate(sqlDate);
	}

	public List<MovieEntity> getMoviePresenting() {
		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		return (List<MovieEntity>) movieRepository.findByStartEndDate(sqlDate);
	}

	@Override
	public List<MovieEntity> getAllMovie() {
		return (List<MovieEntity>) movieRepository.findAll();
	}

	@Override
	public List<MovieEntity> getMovieByUserId(Long userId) {
		// TODO Auto-generated method stub
		return (List<MovieEntity>) movieRepository.findByUserId(userId);
	}

	@Override
	public void saveMovie(MovieEntity movie) {
		// TODO Auto-generated method stub
		movieRepository.save(movie);
	}

	@Override
	public void createMovieByUserId(Long userId) {
		List<MovieEntity> movieName = movieRepository.findByUserId(userId);

		MovieEntity movie = new MovieEntity();
		
		movieName.add(movie);
		saveMovie(movie);
		System.out.println(movieName);
	}
}
