package com.mindtree.moviebookingapplication.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import lombok.Data;

@NamedQuery(
	    name = "findTicketsByUser",
	    query = "FROM Ticket t WHERE t.user.userId = :userId"
	)

@Entity
@Data
public class Ticket implements Comparable<Ticket>{
	
	@Id
	@GeneratedValue
	private Long ticketId;

	@OneToOne
	private MovieUser user;
	
	@OneToOne 
	private Show show;
	
	private LocalDate bookingDate;
	
	public Ticket(MovieUser user, Show show) {

		this.user = user;
		this.show = show;
		this.bookingDate = LocalDate.now();

	}
	
	public Ticket() {
		
	}

	@Override
	public int compareTo(Ticket o) {
		return this.bookingDate.compareTo(o.bookingDate);
	}



}
