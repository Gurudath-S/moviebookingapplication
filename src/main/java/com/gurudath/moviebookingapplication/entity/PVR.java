package com.gurudath.moviebookingapplication.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.gurudath.moviebookingapplication.constants.Type;

import lombok.Data;

@Entity
@Data
public class PVR implements Cinema {

	@Id
	private String location;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Screen> screens;

	@Override
	public List<Screen> getScreens() {
		return this.screens;
	}

	@Override
	public Type getType() {
		return Type.PVR;
	}

}
