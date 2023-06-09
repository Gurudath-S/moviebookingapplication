package com.gurudath.moviebookingapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidCinemaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7340209708952111278L;

	public InvalidCinemaException() {
		// TODO Auto-generated constructor stub
	}

	public InvalidCinemaException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidCinemaException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidCinemaException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidCinemaException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
