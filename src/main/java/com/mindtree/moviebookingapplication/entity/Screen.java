package com.mindtree.moviebookingapplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.mindtree.moviebookingapplication.constants.Type;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Screen implements Comparable<Screen>{

	public Screen(Movie mov, Type type) {
		this.movie = mov;
		this.cinema = type;
	}

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne
	private Movie movie;

	private Type cinema;

	@Override
	public int compareTo(Screen o) {
		return this.id.compareTo(o.id);
	}

}
