package com.cm.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cm.entities.AccountEntity;
import com.cm.entities.MovieEntity;
import com.cm.repositories.MovieRepository;
import com.cm.services.interfaces.AccountService;
import com.cm.services.interfaces.MovieService;

/**
 * @author BaoTHD
 *
 */
@Service
@Transactional
public class MovieServiceImp implements MovieService {

	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private AccountService accountService;

	@Override
	public List<MovieEntity> getComingSoonMovie() {
		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		return (List<MovieEntity>) movieRepository.findByStartDate(sqlDate);
	}
	
	@Override
	public List<MovieEntity> getPresentingMovie() {
		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		return (List<MovieEntity>) movieRepository.findByStartEndDate(sqlDate);
	}

	/* 
	 * @author: BaoTHD
	 */
	@Override
	public List<MovieEntity> getAllMovie() {
		return movieRepository.findAll();
	}

	/* 
	 * @author: BaoTHD
	 */
	@Override
	public MovieEntity getMovieByMovieId(Long movieId) {
		return movieRepository.findByMovieId(movieId);
	}

	
	/* 
	 * @author: BaoTHD
	 * Change isActive from true to false
	 */
	@Override
	public boolean changeMovieState(MovieEntity movie) {
		// TODO Auto-generated method stub
		if (movie.getIsActive() == true) {
			movie.setIsActive(false);
			movieRepository.setFixedMovieFor(movie.getIsActive(), movie.getMovieId());
			return true;
		}
		return false;
	}

	@Override
	public void saveMovie(MovieEntity movie) {
		// TODO Auto-generated method stub
		movieRepository.save(movie);
	}

	@Override
	public List<MovieEntity> getMovieByUserId(Long userID) {
		// TODO Auto-generated method stub
		return (List<MovieEntity>) movieRepository.findByUserId(userID);
	}

	public void createMovieByUserId(Long userID, String movieName, String introduction, String actor,
			String genre, Date startDate, Date endDate, String trailer, String picture, Integer lenght, Boolean isActive,
			List<MovieEntity> lisftOfMovie) {
		// TODO Auto-generated method stub

		
		AccountEntity user = accountService.findById(userID);
		MovieEntity movie = new MovieEntity();

		movie.setAccounts(user);
		movie.setMovieName(movieName);
		movie.setIntroduction(introduction);
		movie.setActor(actor);
		movie.setGenre(genre);
		movie.setStartDate(startDate);
		movie.setEndDate(endDate);
		movie.setTrailer(trailer);
		movie.setPicture(picture);
		movie.setLenght(lenght);
		movie.setIsActive(true);
		movieRepository.save(movie);
		lisftOfMovie.add(movie);
	}

	@Override
	public void updateMovie(MovieEntity movie, String movieName, String introduction, String actor, String genre,
			Date startDate, Date endDate, String trailer, String picture, int lenght) {
		// TODO Auto-generated method stub
		movie.setMovieName(movieName);
		movie.setIntroduction(introduction);
		movie.setActor(actor);
		movie.setGenre(genre);
		movie.setStartDate(startDate);
		movie.setEndDate(endDate);
		movie.setPicture(picture);
		movie.setTrailer(trailer);
		movie.setLenght(lenght);
		movieRepository.setFixedMovieFor(movie.getMovieName(), movie.getIntroduction(), movie.getActor(),
				movie.getGenre(), movie.getStartDate(), movie.getEndDate(), movie.getTrailer(), movie.getPicture(),
				movie.getLenght(), movie.getMovieId());
	}
}
