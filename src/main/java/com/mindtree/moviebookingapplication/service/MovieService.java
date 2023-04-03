package com.mindtree.moviebookingapplication.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.mindtree.moviebookingapplication.entity.Movie;

@Service
public interface MovieService {
	
	public List<Movie> getAllMovies();
	
	public List<Movie> getAllMoviesByCinema(String cinema);
	
	public List<Movie> getAllMoviesByShowTiming(String showTiming);

	Set<Movie> getAllMoviesByDate(String date);

}
