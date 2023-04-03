package com.gurudath.moviebookingapplication.controller;

import com.gurudath.moviebookingapplication.serviceimpl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gurudath.moviebookingapplication.dto.UserDto;
import com.gurudath.moviebookingapplication.entity.MovieUser;
import com.gurudath.moviebookingapplication.exception.IncorrectPasswordException;
import com.gurudath.moviebookingapplication.exception.UserNotFoundException;

@RestController
@RequestMapping("/user")
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
    UserServiceImpl userService;

	@PostMapping("/login")
	public ResponseEntity<UserDto> login(@RequestHeader String userName, @RequestHeader String password)
			throws UserNotFoundException, IncorrectPasswordException {
		logger.info("Verifying user credentials");
		UserDto user = new UserDto();
		MovieUser validateUser = userService.login(userName, password);
		user.setUserId(validateUser.getUserId());
		user.setUserName(validateUser.getUserName());
		return ResponseEntity.ok().body(user);
	}
	
}
