package com.mindtree.moviebookingapplication.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import com.mindtree.moviebookingapplication.constants.ShowTiming;

import lombok.Data;
import lombok.NoArgsConstructor;


@NamedQuery(
	    name = "Movie.findMoviesByShowTime",
	    query = "SELECT m FROM Movie m JOIN m.showCycle s WHERE s = :showTime"
	)

@Entity
@Data
@NoArgsConstructor
public class Movie implements Comparable<Movie>{
	
	 public Movie(String title, LocalDate releaseDate, List<ShowTiming> showTimings) {
	        this.title = title;
	        this.releaseDate = releaseDate;
	        this.showCycle = showTimings;
	    }

	@Id
	@GeneratedValue
	private Long movieId;
	
	private String title;
	
	private LocalDate releaseDate;
	
	@ElementCollection
	@Enumerated(EnumType.STRING)
	private List<ShowTiming> showCycle;

	@Override
	public int compareTo(Movie o) {
		return this.releaseDate.compareTo(o.releaseDate);
	}
	
	
}
