package com.mindtree.moviebookingapplication.service;

import java.util.List;

import com.mindtree.moviebookingapplication.dto.TicketDto;
import com.mindtree.moviebookingapplication.entity.Show;
import com.mindtree.moviebookingapplication.exception.TicketNotFoundException;
import com.mindtree.moviebookingapplication.exception.UserNotFoundException;

public interface TicketService {
	
	public List<TicketDto> getUserTickets(Long userId);
	
	public TicketDto bookTicket(Long userId, Show show) throws UserNotFoundException;
	
	public TicketDto updateShow(Long ticketId, Show show) throws TicketNotFoundException;
	
	public TicketDto cancelShow(Long ticketId) throws TicketNotFoundException;

}
