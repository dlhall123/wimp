package com.lmig.gfc.wimp.api;

import static org.mockito.Mockito.mock;

import com.lmig.gfc.wimp.services.ActorRepository;
import com.lmig.gfc.wimp.services.MovieRepository;

public class ActorsInMoviesApiControllerTests {
	private ActorsInMoviesApiController controller;
	private MovieRepository mr;
	private ActorRepository ar;

	public ActorsInMoviesApiControllerTests() {
		mr = mock(MovieRepository.class);
		ar = mock(ActorRepository.class);
		controller = new ActorsInMoviesApiController(mr, ar);
	}

	// @Test
	// public void create_finds_movie_and_actor_saves_movie() {
	// // Arrange
	// Movie movie = new Movie();
	// movie.setActors(new ArrayList<Actor>());
	// Actor actor = new Actor();
	// when(mr.findOne(1L)).thenReturn(movie);
	// when(ar.findOne(2L)).thenReturn(actor);
	// // Act
	// Movie actual = controller.create(1L, 2L);
	// // Assert
	// assertThat(actual).isSameAs(movie);
	// assertThat(movie.getActors().size()).isEqualTo(1);
	// verify(mr).findOne(1L);
	// verify(ar).findOne(2L);
	// verify(mr).save(movie);
	// }

}
