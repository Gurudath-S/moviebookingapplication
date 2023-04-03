package com.gurudath.moviebookingapplication.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import com.gurudath.moviebookingapplication.constants.ShowTiming;

import lombok.Data;


@NamedQuery(name = "findAllShowsByCinema",
	query = "SELECT s FROM Show s WHERE s.screen.cinema = :cinema")

@Entity
@Data
public class Show implements Comparable<Show>{

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne
	private Screen screen;

	private ShowTiming showTiming;

	private LocalDate showDate;

	public Show(Screen screen, ShowTiming showTiming, LocalDate showDate) {
		this.screen = screen;
		this.showTiming = showTiming;
		this.showDate = showDate;
	}

	public Show() {

	}

	@Override
	public int compareTo(Show o) {
	    return this.showDate.compareTo(o.showDate);
	}

}
