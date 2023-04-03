package com.mindtree.moviebookingapplication.entity;

import java.util.List;

import com.mindtree.moviebookingapplication.constants.Type;

public interface Cinema {
	
	public Type getType();

	public List<Screen> getScreens();

}
