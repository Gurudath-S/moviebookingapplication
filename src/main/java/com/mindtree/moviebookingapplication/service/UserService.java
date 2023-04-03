package com.mindtree.moviebookingapplication.service;

import com.mindtree.moviebookingapplication.entity.MovieUser;
import com.mindtree.moviebookingapplication.exception.IncorrectPasswordException;
import com.mindtree.moviebookingapplication.exception.UserNotFoundException;

public interface UserService {

	public MovieUser login(String userName, String password) throws UserNotFoundException, IncorrectPasswordException;

}
