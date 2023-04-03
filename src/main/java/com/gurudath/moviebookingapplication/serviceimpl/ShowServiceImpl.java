package com.gurudath.moviebookingapplication.serviceimpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gurudath.moviebookingapplication.constants.Type;
import com.gurudath.moviebookingapplication.entity.Show;
import com.gurudath.moviebookingapplication.exception.InvalidCinemaException;
import com.gurudath.moviebookingapplication.repository.ShowRepository;
import com.gurudath.moviebookingapplication.service.ShowService;

@Service
@Transactional
public class ShowServiceImpl implements ShowService {
	
	Logger logger = LoggerFactory.getLogger(ShowServiceImpl.class);

	@Autowired
	ShowRepository showRepository;
	
	@Autowired
	EntityManager entityManager;

	@Override
	public List<Show> getShows() {
		logger.debug("Inside ShowService - fetching all shows");
		return showRepository.findAll();
	}
	
	
	public List<Show> getShowsByCinema(String cinema) throws InvalidCinemaException {
		try {
			logger.debug("Inside Show Service - fetching all shows by cinema");
			return entityManager.createNamedQuery("findAllShowsByCinema", Show.class)
				.setParameter("cinema", Type.valueOf(cinema))
				.getResultList();
		} catch (NoResultException ex) {
			logger.warn("No Shows found for the selected cinema - Throwing no cinema exception");
			throw new InvalidCinemaException("Selected Cinema Does not Exist");
		}
	}


	@Override
	public List<Show> getShowsByDate(String date) {
		logger.debug("Inside show service - Fetching all shows for a particular date");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return showRepository.findAllByShowDate(LocalDate.parse(date, formatter));
	}

}
