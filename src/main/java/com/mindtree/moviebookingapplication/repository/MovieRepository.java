package com.mindtree.moviebookingapplication.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.moviebookingapplication.entity.Movie;

@Repository
@Qualifier("MovieRepository")
public interface MovieRepository extends JpaRepository<Movie, Long> {


}
