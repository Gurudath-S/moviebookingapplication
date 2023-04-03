package com.mindtree.moviebookingapplication.controller;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.moviebookingapplication.entity.Movie;
import com.mindtree.moviebookingapplication.serviceimpl.MovieServiceImpl;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	MovieServiceImpl movieService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Movie>> getMovies(){
		logger.info("Fetching list of movies");
		return ResponseEntity.ok().body(movieService.getAllMovies());
	}
	
	
	@GetMapping("/show/{showTime}")
	public ResponseEntity<List<Movie>> getMoviesByShowTiming(@PathVariable String showTime){
		logger.info("Fetching list of movies by showtime");
		return ResponseEntity.ok().body(movieService.getAllMoviesByShowTiming(showTime));
	}
	
	@GetMapping("/show/date")
	public ResponseEntity<Set<Movie>> getMoviesByShowDate(@RequestParam String showDate){
		logger.info("Fetching list of movies by showdate");
		return ResponseEntity.ok().body(movieService.getAllMoviesByDate(showDate));
	}

}
