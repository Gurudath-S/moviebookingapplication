package com.gurudath.moviebookingapplication.controller;

import java.util.List;

import com.gurudath.moviebookingapplication.repository.UserRepository;
import com.gurudath.moviebookingapplication.serviceimpl.TicketServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gurudath.moviebookingapplication.dto.TicketDto;
import com.gurudath.moviebookingapplication.entity.Show;
import com.gurudath.moviebookingapplication.exception.TicketNotFoundException;
import com.gurudath.moviebookingapplication.exception.UserNotFoundException;

@RestController
public class TicketController {
	
	Logger logger = LoggerFactory.getLogger(TicketController.class);
	
	@Autowired
    TicketServiceImpl ticketService;
	
	@Autowired
    UserRepository userRepository;

	@GetMapping("/tickets/user")
	public ResponseEntity<List<TicketDto>> getAllTickets(@RequestParam Long userId) throws UserNotFoundException{
		logger.info("Fetching all tickets for user Id: "+userId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("userId", userId.toString());
		userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User Id not found"));
		return ResponseEntity.ok().headers(headers).body(ticketService.getUserTickets(userId));
	}
	
	@PostMapping("/tickets/user")
	public ResponseEntity<TicketDto> bookTicket(@RequestHeader Long userId, @RequestBody Show show) throws UserNotFoundException {
		logger.info("Booking ticket for user id :" +userId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("userId", userId.toString());
		userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User Id not found"));
		return ResponseEntity.ok().headers(headers).body(ticketService.bookTicket(userId, show));
	}
	
	@PutMapping("/tickets/user")
	public ResponseEntity<TicketDto> updateShow(@RequestHeader Long ticketId,@RequestHeader Long userId, @RequestBody Show show) throws TicketNotFoundException, UserNotFoundException{
		logger.info("Updating show for the ticket :"+ticketId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("userId", userId.toString());
		userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User Id not found"));
		return ResponseEntity.ok().headers(headers).body(ticketService.updateShow(ticketId, show));
	}
	
	@DeleteMapping("/tickets/user")
	public ResponseEntity<TicketDto> cancelTicket(@RequestHeader Long ticketId, @RequestHeader Long userId) throws UserNotFoundException, TicketNotFoundException{
		logger.info("Cancelling ticket with ticket id: "+ticketId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("userId", userId.toString());
		userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User Id not found"));
		return ResponseEntity.ok().headers(headers).body(ticketService.cancelShow(ticketId));
	}
	
}
