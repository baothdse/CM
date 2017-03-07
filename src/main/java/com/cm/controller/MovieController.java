package com.cm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@RequestMapping(value = URLConstants.MOVIE_URL)
public class MovieController {

	@Autowired
	MovieService movieService;
	
	private MovieEntity movie;
	private List<MovieEntity> listOfMovie;

	@RequestMapping(value = URLConstants.GET_MOVIE_SOON, method = RequestMethod.GET)
	public ResponseEntity<?> getComingSoon() {
		listOfMovie = (List<MovieEntity>) movieService.getComingSoonMovie();
		//System.out.println(movie);
		return new ResponseEntity<List<MovieEntity>>(listOfMovie, HttpStatus.OK);
	}

	@RequestMapping(value = URLConstants.GET_MOVIE_NOW, method = RequestMethod.GET)
	public ResponseEntity<?> getMoviePresenting() {

		listOfMovie = (List<MovieEntity>) movieService.getPresentingMovie();
		return new ResponseEntity<List<MovieEntity>>(listOfMovie, HttpStatus.OK);
	}


	/*,
	*/
	@RequestMapping(value = URLConstants.CREATE_MOVIE_URL, method = RequestMethod.POST)
	public ResponseEntity<?> createMovieByUserId(@RequestParam(value = "userId") Long userID,
			@RequestParam(value = ParamConstants.MOVIE_NAME) String movieName, 
			@RequestParam(value = ParamConstants.MOVIE_INTRODUCTION) String introduction,
			@RequestParam(value = ParamConstants.ACTOR) String actor, 
			@RequestParam(value = ParamConstants.GENRE) String genre,
			@RequestParam(value = ParamConstants.START_DATE) Date startDate,
			@RequestParam(value = ParamConstants.END_DATE) Date endDate,
			@RequestParam(value = ParamConstants.TRAILER) String trailer,
			@RequestParam(value = ParamConstants.PICTURE) String picture,
			@RequestParam(value = ParamConstants.ISACTIVE) Boolean isActive,
			@RequestParam(value = ParamConstants.LENGHT) Integer lenght) throws ParseException {
		
		List<MovieEntity> listOfMovie = movieService.getAllMovie();
		boolean checkDuplicate = true;
		MovieEntity movie = null;
		
		CustomError error = new CustomError(ErrorConstants.ER007, ErrorConstants.ER007);
		for (MovieEntity movieEntity : listOfMovie) {
			if (movieEntity.getMovieName().equals(movieName)) {
				checkDuplicate = false;
			} else {
				checkDuplicate = true;
			}
		}
		if (checkDuplicate == false) {
			return new ResponseEntity<CustomError>(error, HttpStatus.OK);
		} else {
			if (movieService.getMovieByUserId(userID) != null) {
				movieService.createMovieByUserId(userID, movieName, introduction, actor, genre, startDate, endDate, trailer, picture, lenght, isActive, listOfMovie);
				movie = listOfMovie.get(listOfMovie.size() - 1);
				return new ResponseEntity<MovieEntity>(movie, HttpStatus.OK);
			} else {
				CustomError customError = new CustomError(ErrorConstants.ER008, ErrorConstants.EM008);
				return new ResponseEntity<CustomError>(customError, HttpStatus.OK);
			}
		
		}
		
}

	/**
	 * @author BaoTHD
	 * @return
	 */
	@RequestMapping(value = URLConstants.GET_ALL_MOVIE, method = RequestMethod.GET)
	public ResponseEntity<?> getAllMovie() {
		listOfMovie = movieService.getAllMovie();
		return new ResponseEntity<List<MovieEntity>>(listOfMovie, HttpStatus.OK);
	}

	/**
	 * @author BaoTHD
	 * @param movieId
	 * @return
	 */
	@RequestMapping(value = URLConstants.CHANGE_MOVIE_STATE_URL, method = RequestMethod.POST)
	public ResponseEntity<?> changeMovieState(@RequestParam(value = ParamConstants.MOVIE_ID) Long movieId) {
		movie = movieService.getMovieByMovieId(movieId);
		CustomError error = new CustomError(ErrorConstants.ER006, ErrorConstants.EM006);
		if (movieService.changeMovieState(movie) == true) {
			return new ResponseEntity<MovieEntity>(movie, HttpStatus.OK);
		}
		return new ResponseEntity<CustomError>(error, HttpStatus.OK);
	}

	@RequestMapping(value = URLConstants.UPDATE_MOVIE_INFO_URL, method = RequestMethod.POST)
	public ResponseEntity<?> updateMovieInfo(@RequestParam(value = ParamConstants.MOVIE_ID) Long movieId,
			@RequestParam(value = ParamConstants.MOVIE_NAME) String movieName,
			@RequestParam(value = ParamConstants.MOVIE_INTRODUCTION) String introduction,
			@RequestParam(value = ParamConstants.ACTOR) String actor,
			@RequestParam(value = ParamConstants.GENRE) String genre,
			@RequestParam(value = ParamConstants.START_DATE) String startDate,
			@RequestParam(value = ParamConstants.END_DATE) String endDate,
			@RequestParam(value = ParamConstants.TRAILER) String trailer,
			@RequestParam(value = ParamConstants.PICTURE) String picture,
			@RequestParam(value = ParamConstants.LENGHT) int lenght) throws ParseException {
		movie = movieService.getMovieByMovieId(movieId);
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		Date movieStartDate = date.parse(startDate);
		Date movieEndDate = date.parse(endDate);

		movieService.updateMovie(movie, movieName, introduction, actor, genre, movieStartDate, movieEndDate, trailer,
				picture, lenght);
		return new ResponseEntity<MovieEntity>(movie, HttpStatus.OK);

	}
}
