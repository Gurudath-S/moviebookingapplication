package com.mindtree.moviebookingapplication.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.mindtree.moviebookingapplication.constants.Type;

import lombok.Data;

@Entity
@Data
public class INOX implements Cinema {

	@Id
	private Long cinemaId;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Screen> screens;

	@Override
	public List<Screen> getScreens() {
		return this.screens;
	}

	@Override
	public Type getType() {
		return Type.INOX;
	}

}
