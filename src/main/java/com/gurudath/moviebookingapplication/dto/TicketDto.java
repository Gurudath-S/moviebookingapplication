package com.gurudath.moviebookingapplication.dto;

import java.time.LocalDate;

import javax.persistence.OneToOne;

import com.gurudath.moviebookingapplication.entity.Show;
import com.gurudath.moviebookingapplication.entity.Ticket;

import lombok.Data;


 
@Data
public class TicketDto {

	private Long ticketId;

	private String userName;

	@OneToOne
	private Show show;

	private LocalDate bookingDate;
	

	public TicketDto() {
	}


	public TicketDto(Ticket p) {
		this.ticketId = p.getTicketId();
		this.userName = p.getUser().getUserName();
		this.show = p.getShow();
		this.bookingDate = p.getBookingDate();
	}

	
}
