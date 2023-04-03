package com.gurudath.moviebookingapplication.service;

import java.util.List;

import com.gurudath.moviebookingapplication.exception.TicketNotFoundException;
import com.gurudath.moviebookingapplication.exception.UserNotFoundException;
import com.gurudath.moviebookingapplication.dto.TicketDto;
import com.gurudath.moviebookingapplication.entity.Show;

public interface TicketService {
	
	public List<TicketDto> getUserTickets(Long userId);
	
	public TicketDto bookTicket(Long userId, Show show) throws UserNotFoundException;
	
	public TicketDto updateShow(Long ticketId, Show show) throws TicketNotFoundException;
	
	public TicketDto cancelShow(Long ticketId) throws TicketNotFoundException;

}
