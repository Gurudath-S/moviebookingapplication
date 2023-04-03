package com.mindtree.moviebookingapplication.controller.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import com.mindtree.moviebookingapplication.constants.ShowTiming;
import com.mindtree.moviebookingapplication.controller.MovieController;
import com.mindtree.moviebookingapplication.entity.Movie;
import com.mindtree.moviebookingapplication.repository.UserRepository;
import com.mindtree.moviebookingapplication.serviceimpl.MovieServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class MovieControllerTest {
	
	@Mock
	MovieServiceImpl movieService;
	
	@Mock
	UserRepository userRepo;
	
	@InjectMocks
	MovieController movieController;
	
	@Test
	public void getAllMoviesTest() {
		ArrayList<Movie> movies = new ArrayList<>();
		Mockito.when(movieService.getAllMovies()).thenReturn(movies);
		Assert.assertEquals(movies, movieController.getMovies().getBody());
	}
	
	@Test
	public void getMoviesByShowTimingTest() {
		ShowTiming time = ShowTiming.EVENING;
		ArrayList<Movie> movies = new ArrayList<>();
		Mockito.when(movieService.getAllMoviesByShowTiming(time.toString())).thenReturn(movies);
		Assert.assertEquals(movies, movieController.getMoviesByShowTiming(time.toString()).getBody());
		Assert.assertEquals(HttpStatus.OK,  movieController.getMoviesByShowTiming(time.toString()).getStatusCode());
	}
	
	@Test
	public void getMoviesByShowDateTest() {
		Set<Movie> movieList = new TreeSet<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse("2022-12-12", formatter);
		Mockito.when(movieService.getAllMoviesByDate(date.toString())).thenReturn(movieList);
		Assert.assertEquals(movieList, movieController.getMoviesByShowDate(date.toString()).getBody());
		Assert.assertEquals(HttpStatus.OK, movieController.getMoviesByShowDate(date.toString()).getStatusCode());
	}

}
