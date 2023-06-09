package com.gurudath.moviebookingapplication.controller;

import java.util.List;
import java.util.NoSuchElementException;

import com.gurudath.moviebookingapplication.repository.UserRepository;
import com.gurudath.moviebookingapplication.serviceimpl.ShowServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gurudath.moviebookingapplication.entity.Show;
import com.gurudath.moviebookingapplication.exception.InvalidCinemaException;
import com.gurudath.moviebookingapplication.exception.UserNotFoundException;

@RestController
public class ShowController {
	
	Logger logger = LoggerFactory.getLogger(ShowController.class);

	@Autowired
    ShowServiceImpl showService;

	@Autowired
    UserRepository userRepository;

	@PostMapping("/shows")
	public ResponseEntity<List<Show>> getAllShows(@RequestParam Long userId)
			throws UserNotFoundException, NoSuchElementException {
		HttpHeaders headers = new HttpHeaders();
		headers.add("userId", userId.toString());
		logger.info("Fetching all shows");
		userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User Id not found"));
		return ResponseEntity.ok().headers(headers).body(showService.getShows());
	}

	@PostMapping("/shows/{cinema}")
	public ResponseEntity<List<Show>> getShowsByCinema(@PathVariable String cinema, @RequestParam Long userId)
			throws UserNotFoundException, NoSuchElementException, InvalidCinemaException {
		HttpHeaders headers = new HttpHeaders();
		headers.add("userId", userId.toString());
		logger.info("Fetching shows for a particular cinema");
	    userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User Id not found"));
		return ResponseEntity.ok().headers(headers).body(showService.getShowsByCinema(cinema));
	}
}
