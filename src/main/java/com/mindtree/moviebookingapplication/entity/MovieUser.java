package com.mindtree.moviebookingapplication.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
public class MovieUser implements Comparable<MovieUser>{
	
	public MovieUser(String userName, String userPassword) {
		this.userName=userName;
		this.userPassword=userPassword;
	}

	@Id
	@GeneratedValue
	private Long userId;
	
	private String userName;
	
	private String userPassword;
	
	@OneToMany(mappedBy = "user")
	private List<Ticket> tickets;

	@Override
	public int compareTo(MovieUser o) {
		return this.userId.compareTo(o.userId);
	}
	
	
}
