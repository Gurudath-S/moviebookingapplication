package com.mindtree.moviebookingapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.moviebookingapplication.entity.Screen;

@Repository
public interface ScreenRepository extends JpaRepository<Screen, Long> {
	
	public List<Screen> findAllByCinema(String cinema);

	
}
