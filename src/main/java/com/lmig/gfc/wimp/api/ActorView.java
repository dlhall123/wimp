package com.lmig.gfc.wimp.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Award;
import com.lmig.gfc.wimp.models.Movie;

public class ActorView {

	private Actor actor;

	public ActorView(Actor a) {
		actor = a;
	}

	public Long getId() {
		return actor.getId();
	}

	public String getFirstName() {
		return actor.getFirstName();
	}

	public String getLastName() {
		return actor.getLastName();
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	public Date getBirthDate() {
		return actor.getBirthDate();
	}

	public Long getActiveSinceYear() {
		return actor.getActiveSinceYear();
	}

	public List<Award> getAwards() {
		return actor.getAwards();
	}

	public List<MovieView> getMovies() {
		ArrayList<MovieView> movies = new ArrayList<>();
		for (Movie movie : actor.getMovies()) {
			movies.add(new MovieView(movie));
		}
		return movies;
	}

}
