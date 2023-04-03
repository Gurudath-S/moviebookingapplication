package com.mindtree.moviebookingapplication.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.moviebookingapplication.entity.MovieUser;
import com.mindtree.moviebookingapplication.exception.IncorrectPasswordException;
import com.mindtree.moviebookingapplication.exception.UserNotFoundException;
import com.mindtree.moviebookingapplication.repository.UserRepository;
import com.mindtree.moviebookingapplication.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	public UserRepository userRepository;

	@Override
	public MovieUser login(String userName, String password) throws UserNotFoundException, IncorrectPasswordException {
	    MovieUser user = userRepository.findByUserName(userName);
	    if (user == null) {
	        throw new UserNotFoundException("User with username " + userName + " does not exist");
	    }
	    if (!user.getUserPassword().equals(password)) {
	    	logger.error("Incorrect password !");
	    	throw new IncorrectPasswordException("Password wrong for username" + userName);
	    }
	    return user;
	}


}
