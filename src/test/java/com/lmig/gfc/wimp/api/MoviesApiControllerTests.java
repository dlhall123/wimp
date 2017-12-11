package com.lmig.gfc.wimp.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lmig.gfc.wimp.models.Movie;
import com.lmig.gfc.wimp.services.MovieRepository;

public class MoviesApiControllerTests {
	private MoviesApiController controller;
	private MovieRepository movieRepo;

	public MoviesApiControllerTests() {
		movieRepo = mock(MovieRepository.class);
		controller = new MoviesApiController(movieRepo);
	}

	@Test
	public void getAll_runs_findAll_returns_list_of_movies() {
		// Arrange
		ArrayList<Movie> movieList = new ArrayList<Movie>();
		when(movieRepo.findAll()).thenReturn(movieList);
		// Act

		List<Movie> actual = controller.getAll();

		// Assert
		assertThat(actual).isSameAs(movieList);
		verify(movieRepo).findAll();
	}

	@Test
	public void getOne_returns_correct_movie() {
		// Arrange
		Movie movie = new Movie();
		when(movieRepo.findOne(2L)).thenReturn(movie);
		// Act
		Movie actual = controller.getOne(2L);
		// Assert
		assertThat(actual).isSameAs(movie);
		verify(movieRepo).findOne(2L);
	}

	@Test
	public void getOne_returns_null_movie_for_invalid_id() {
		// Arrange
		// Act
		Movie actual = controller.getOne(1L);

		// Assert
		assertThat(actual).isNull();
		verify(movieRepo).findOne(1L);
	}

	@Test
	public void create_saves_and_returns_movie() {
		// Arrange
		Movie movie = new Movie();
		when(movieRepo.save(movie)).thenReturn(movie);
		// Act
		Movie actual = controller.create(movie);
		// Assert
		assertThat(actual).isSameAs(movie);
		verify(movieRepo).save(movie);
	}

	@Test
	public void update_sets_movie_id_and_saves_movie() {
		// Arrange
		Movie movie = new Movie();
		when(movieRepo.save(movie)).thenReturn(movie);

		// Act
		Movie actual = controller.update(1L, movie);

		// Assert
		assertThat(actual).isSameAs(movie);
		assertThat(actual.getId()).isEqualTo(1L);
		verify(movieRepo).save(movie);

	}

	@Test
	public void delete_deletes_movie_returns_deleted_movie() {
		// Arrange
		Movie movie = new Movie();
		when(movieRepo.findOne(1L)).thenReturn(movie);

		// Act
		Movie actual = controller.delete(1L);

		// Assert
		assertThat(actual).isSameAs(movie);
		verify(movieRepo).delete(1L);
		verify(movieRepo).findOne(1L);

	}

}
