package com.gurudath.moviebookingapplication.entity;

import java.util.List;

import com.gurudath.moviebookingapplication.constants.Type;

public interface Cinema {
	
	public Type getType();

	public List<Screen> getScreens();

}
