package com.gurudath.moviebookingapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gurudath.moviebookingapplication.entity.MovieUser;

@Repository
public interface UserRepository extends JpaRepository<MovieUser, Long> {
	
	public MovieUser findByUserName(String userName);

}
