package com.gurudath.moviebookingapplication.serviceimpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gurudath.moviebookingapplication.constants.ShowTiming;
import com.gurudath.moviebookingapplication.entity.Movie;
import com.gurudath.moviebookingapplication.entity.Screen;
import com.gurudath.moviebookingapplication.repository.MovieRepository;
import com.gurudath.moviebookingapplication.repository.ScreenRepository;
import com.gurudath.moviebookingapplication.repository.ShowRepository;
import com.gurudath.moviebookingapplication.service.MovieService;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {
	
	Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private ScreenRepository screenRepository;

	@Autowired
	private ShowRepository showRepository;

	@Autowired
	EntityManager entityManager;

	@Override
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	public List<Movie> getAllMoviesByCinema(String cinema) {
		List<Screen> screens = screenRepository.findAllByCinema(cinema);
		logger.debug("Inside Movie service - Fetching all movies by cinema");
		return screens.stream().map(p -> p.getMovie()).collect(Collectors.toList());
	}

	@Override
	public Set<Movie> getAllMoviesByDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		logger.debug("Inside Movie service - Fetching movies by date");
		return showRepository.findAllByShowDate(LocalDate.parse(date, formatter)).stream()
				.map(p -> p.getScreen().getMovie()).collect(Collectors.toSet());
	}

	@Override
	public List<Movie> getAllMoviesByShowTiming(String showTiming) {
		List<Movie> movies = entityManager.createNamedQuery("Movie.findMoviesByShowTime", Movie.class)
				.setParameter("showTime", ShowTiming.valueOf(showTiming)).getResultList();
		logger.debug("Inside Movie Service - Fetching all movies by show time");
		return movies;

	}

}
