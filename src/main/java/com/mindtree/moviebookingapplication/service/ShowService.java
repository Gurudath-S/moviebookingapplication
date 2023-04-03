package com.mindtree.moviebookingapplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.moviebookingapplication.entity.Show;
import com.mindtree.moviebookingapplication.exception.InvalidCinemaException;

@Service
public interface ShowService {
	
	public List<Show> getShows();
	
	public List<Show> getShowsByCinema(String cinema) throws InvalidCinemaException;
	
	public List<Show> getShowsByDate(String cinema);

}
