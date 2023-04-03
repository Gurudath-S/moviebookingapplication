package com.mindtree.moviebookingapplication.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.moviebookingapplication.dto.TicketDto;
import com.mindtree.moviebookingapplication.entity.MovieUser;
import com.mindtree.moviebookingapplication.entity.Show;
import com.mindtree.moviebookingapplication.entity.Ticket;
import com.mindtree.moviebookingapplication.exception.TicketNotFoundException;
import com.mindtree.moviebookingapplication.exception.UserNotFoundException;
import com.mindtree.moviebookingapplication.repository.ShowRepository;
import com.mindtree.moviebookingapplication.repository.TicketRepository;
import com.mindtree.moviebookingapplication.repository.UserRepository;
import com.mindtree.moviebookingapplication.service.TicketService;


@Service
@Transactional
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	ShowRepository showRepo;
	
	@Autowired
	TicketRepository ticketRepo;
	
	@Autowired
	EntityManager entityManager;

	@Override
	public List<TicketDto> getUserTickets(Long userId) {
		List<Ticket> tickets = entityManager
		    .createNamedQuery("findTicketsByUser", Ticket.class)
		    .setParameter("userId", userId)
		    .getResultList();
		List<TicketDto> ticketDtos = tickets.stream().map(p -> new TicketDto(p)).collect(Collectors.toList());
		return ticketDtos;
		
	}

	@Override
	public TicketDto bookTicket(Long userId, Show show) throws UserNotFoundException {
		MovieUser user = userRepo.findById(userId).orElseThrow(() ->  new UserNotFoundException("User Id not found"));
		Ticket ticket = new Ticket(user, show);
		ticketRepo.save(ticket);
		return new TicketDto(ticket);
	}

	@Override
	public TicketDto updateShow(Long ticketId, Show show) throws TicketNotFoundException {
		Ticket ticket = ticketRepo.findById(ticketId).orElseThrow(() ->  new TicketNotFoundException("Ticket id not found"));
		ticket.setShow(show);
		ticketRepo.save(ticket);
		return new TicketDto(ticket);
	}

	@Override
	public TicketDto cancelShow(Long ticketId) throws TicketNotFoundException {
		Ticket ticket = ticketRepo.findById(ticketId)
				.orElseThrow(() ->  new TicketNotFoundException("Ticket id not found"));
		ticketRepo.delete(ticket);
		return new TicketDto(ticket);
	}

}
