package com.mindtree.moviebookingapplication.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.moviebookingapplication.entity.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {

	public List<Show> findAllByShowDate(LocalDate date);

}
