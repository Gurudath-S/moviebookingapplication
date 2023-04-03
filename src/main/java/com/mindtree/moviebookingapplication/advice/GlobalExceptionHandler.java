package com.mindtree.moviebookingapplication.advice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.persistence.NoResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mindtree.moviebookingapplication.exception.InvalidCinemaException;
import com.mindtree.moviebookingapplication.exception.InvalidDateException;
import com.mindtree.moviebookingapplication.exception.InvalidShowTimeException;
import com.mindtree.moviebookingapplication.exception.TicketNotFoundException;
import com.mindtree.moviebookingapplication.exception.UserNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException exception) {
		Map<String, Object> responseBody = new HashMap<>();
		responseBody.put("message", exception.getMessage());
        logger.error("No user found with the given user ID");
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);

		return new ResponseEntity<>(responseBody, responseHeaders, HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<Object> handleMethodNotSupportedException(HttpRequestMethodNotSupportedException exception){
		Map<String, Object> responseBody = new HashMap<>();
		responseBody.put("message", exception.getMessage());
        logger.error("Method not allowed");
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<>(responseBody, responseHeaders, HttpStatus.METHOD_NOT_ALLOWED);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException exception) {
		Map<String, Object> responseBody = new HashMap<>();
		responseBody.put("message", "No Data Found");
		logger.error("No Data Found", exception.getMessage());
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);

		return new ResponseEntity<>(responseBody, responseHeaders, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidCinemaException.class)
	public ResponseEntity<Object> handleInvalidCinemaException(InvalidCinemaException exception) {
		Map<String, Object> responseBody = new HashMap<>();
		responseBody.put("message", "Cinema invalid");
		logger.error("No Such cinema found",exception.getMessage());
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<>(responseBody, responseHeaders, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidDateException.class)
	public ResponseEntity<Object> handleInvalidDateException(InvalidDateException exception){
		Map<String, Object> responseBody = new HashMap<>();
		responseBody.put("message", "Selected Date invalid");
		logger.error("Invalid Date entered", exception.getMessage());
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<>(responseBody, responseHeaders, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidShowTimeException.class)
	public ResponseEntity<Object> handleInvalidShowTimeException(InvalidShowTimeException exception) {
		Map<String, Object> responseBody = new HashMap<>();
		responseBody.put("message", "Selected show Date invalid");
		logger.error("Invalid Show Time entered", exception.getMessage());
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<>(responseBody, responseHeaders, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TicketNotFoundException.class)
	public ResponseEntity<Object> handleTicketNotFoundException(TicketNotFoundException exception) {
		Map<String, Object> responseBody = new HashMap<>();
		responseBody.put("message", "No ticket found for the selected ticket Id");
		logger.error("Ticket not found",exception.getMessage());
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<>(responseBody, responseHeaders, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoResultException.class)
	public ResponseEntity<Object> handleNoResultException(NoResultException exception){
		Map<String, Object> responseBody = new HashMap<>();
		responseBody.put("message", "No Data Found");
		logger.error("No Results Found", exception.getMessage());
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<>(responseBody, responseHeaders, HttpStatus.NO_CONTENT);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleGenericException(Exception exception){
		Map<String, Object> responseBody = new HashMap<>();
		responseBody.put("message", "Internal Server Error");
		logger.error("Uncaught exception occured !", exception.getMessage());
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<>(responseBody, responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
