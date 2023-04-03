package com.mindtree.moviebookingapplication.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mindtree.moviebookingapplication.constants.ShowTiming;
import com.mindtree.moviebookingapplication.constants.Type;
import com.mindtree.moviebookingapplication.entity.Movie;
import com.mindtree.moviebookingapplication.entity.MovieUser;
import com.mindtree.moviebookingapplication.entity.Screen;
import com.mindtree.moviebookingapplication.entity.Show;
import com.mindtree.moviebookingapplication.entity.Ticket;
import com.mindtree.moviebookingapplication.repository.MovieRepository;
import com.mindtree.moviebookingapplication.repository.ScreenRepository;
import com.mindtree.moviebookingapplication.repository.ShowRepository;
import com.mindtree.moviebookingapplication.repository.TicketRepository;
import com.mindtree.moviebookingapplication.repository.UserRepository;

@Configuration
public class MovieConfiguration {
	Logger logger = LoggerFactory.getLogger(MovieConfiguration.class);

	@Bean
	@Qualifier("movieList")
	public List<Movie> init(MovieRepository movieRepo, ScreenRepository screenRepo, UserRepository userRepo,
			ShowRepository showRepo, TicketRepository ticketRepo) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Movie mov1 = new Movie("Movie 1", LocalDate.parse("2022-06-21", formatter),
				Arrays.asList(ShowTiming.EVENING, ShowTiming.MORNING));
		Movie mov2 = new Movie("Movie 2", LocalDate.parse("2022-01-13", formatter),
				Arrays.asList(ShowTiming.MORNING, ShowTiming.NOON));
		Movie mov3 = new Movie("Movie 3", LocalDate.parse("2023-01-12", formatter),
				Arrays.asList(ShowTiming.EVENING, ShowTiming.NIGHT));
		Movie mov4 = new Movie("Movie 4", LocalDate.parse("2023-01-21", formatter),
				Arrays.asList(ShowTiming.EVENING, ShowTiming.NIGHT, ShowTiming.MORNING));
		movieRepo.saveAll(Arrays.asList(mov1, mov2, mov3, mov4));

		Screen screen1 = new Screen(mov1, Type.INOX);
		Screen screen2 = new Screen(mov2, Type.INOX);
		Screen screen3 = new Screen(mov3, Type.INOX);
		Screen screen4 = new Screen(mov4, Type.INOX);
		Screen screen5 = new Screen(mov1, Type.PVR);
		Screen screen6 = new Screen(mov2, Type.PVR);
		Screen screen7 = new Screen(mov3, Type.PVR);
		Screen screen8 = new Screen(mov4, Type.PVR);
		screenRepo.saveAll(Arrays.asList(screen1, screen2, screen3, screen4, screen5, screen6, screen7, screen8));

		Show show1 = new Show(screen1, ShowTiming.NOON, LocalDate.parse("2022-06-21", formatter));
		Show show2 = new Show(screen1, ShowTiming.NIGHT, LocalDate.parse("2022-06-21", formatter));
		Show show3 = new Show(screen2, ShowTiming.MORNING, LocalDate.parse("2022-01-14", formatter));
		Show show4 = new Show(screen2, ShowTiming.NOON, LocalDate.parse("2022-01-15", formatter));
		Show show5 = new Show(screen5, ShowTiming.EVENING, LocalDate.parse("2022-06-22", formatter));
		Show show6 = new Show(screen6, ShowTiming.MORNING, LocalDate.parse("2022-01-15", formatter));
		Show show7 = new Show(screen7, ShowTiming.NIGHT, LocalDate.parse("2022-01-15", formatter));
		showRepo.saveAll(Arrays.asList(show1, show2, show3, show4, show5, show6, show7));

		MovieUser user1 = new MovieUser("User1", "Password1");
		MovieUser user2 = new MovieUser("User2", "Password2");
		userRepo.saveAll(Arrays.asList(user1, user2));

		Ticket ticket1 = new Ticket(user1, show1);
		Ticket ticket2 = new Ticket(user1, show2);
		Ticket ticket3 = new Ticket(user2, show3);
		Ticket ticket4 = new Ticket(user2, show4);
		ticketRepo.saveAll(Arrays.asList(ticket1, ticket2, ticket3, ticket4));

		logger.info("Initialized demo data");
		return Arrays.asList(mov1);

	}

}
