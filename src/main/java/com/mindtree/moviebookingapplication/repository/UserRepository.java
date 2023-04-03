package com.mindtree.moviebookingapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.moviebookingapplication.entity.MovieUser;

@Repository
public interface UserRepository extends JpaRepository<MovieUser, Long> {
	
	public MovieUser findByUserName(String userName);

}
