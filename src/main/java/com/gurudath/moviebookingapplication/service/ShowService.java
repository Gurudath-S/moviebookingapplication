package com.gurudath.moviebookingapplication.service;

import java.util.List;

import com.gurudath.moviebookingapplication.exception.InvalidCinemaException;
import org.springframework.stereotype.Service;

import com.gurudath.moviebookingapplication.entity.Show;

@Service
public interface ShowService {
	
	public List<Show> getShows();
	
	public List<Show> getShowsByCinema(String cinema) throws InvalidCinemaException;
	
	public List<Show> getShowsByDate(String cinema);

}
