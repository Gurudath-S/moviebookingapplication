package com.gurudath.moviebookingapplication.service;

import com.gurudath.moviebookingapplication.exception.IncorrectPasswordException;
import com.gurudath.moviebookingapplication.exception.UserNotFoundException;
import com.gurudath.moviebookingapplication.entity.MovieUser;

public interface UserService {

	public MovieUser login(String userName, String password) throws UserNotFoundException, IncorrectPasswordException;

}
