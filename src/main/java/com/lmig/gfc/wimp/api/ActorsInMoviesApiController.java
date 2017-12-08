package com.lmig.gfc.wimp.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Movie;
import com.lmig.gfc.wimp.services.ActorRepository;
import com.lmig.gfc.wimp.services.MovieRepository;

@RestController
@RequestMapping("/api/movies/{movieId}/actors")
public class ActorsInMoviesApiController {

	private MovieRepository mr;
	private ActorRepository ar;

	public ActorsInMoviesApiController(MovieRepository mr, ActorRepository ar) {
		this.mr = mr;
		this.ar = ar;
	}

	@PostMapping("")
	public Movie create(@PathVariable Long movieId, @RequestBody Long actorId) {
		Movie movie = mr.findOne(movieId);
		Actor actor = ar.findOne(actorId);
		movie.getActors().add(actor);
		mr.save(movie);
		return movie;
	}

}
