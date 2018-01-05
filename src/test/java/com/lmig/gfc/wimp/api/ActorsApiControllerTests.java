package com.lmig.gfc.wimp.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.services.ActorRepository;
import com.lmig.gfc.wimp.services.AwardRepository;

public class ActorsApiControllerTests {
	private ActorsApiController controller;
	private ActorRepository actorRepo;
	private AwardRepository awardRepo;

	@Before
	public void setUp() {
		actorRepo = mock(ActorRepository.class);
		awardRepo = mock(AwardRepository.class);
		controller = new ActorsApiController(actorRepo, awardRepo);
	}

	@Test
	public void GetAll_returns_ActorView_list_with_actor() {
		// Arrange

		ArrayList<Actor> actors = new ArrayList<Actor>();
		Actor actor = new Actor();
		actor.setFirstName("David");
		actor.setId(1L);
		actors.add(actor);
		when(actorRepo.findAll()).thenReturn(actors);

		// Act
		ActorView actual = controller.getAll().get(0);

		// Assert
		assertThat(actual.getFirstName()).isEqualTo("David");
		assertThat(actual.getId()).isEqualTo(1L);
		verify(actorRepo).findAll();
	}

	@Test
	public void GetAll_returns_empty_list_with_empty_list_of_actors() {
		// Arrange

		ArrayList<Actor> actors = new ArrayList<Actor>();
		;
		when(actorRepo.findAll()).thenReturn(actors);

		// Act
		List<ActorView> actual = controller.getAll();

		// Assert
		assertThat(actual).hasSize(0);
	}

	@Test
	public void GetOne_returns_same_actor_as_passed() {
		// Arrange
		Actor actor = new Actor();
		actor.setId(2L);
		when(actorRepo.findOne(2L)).thenReturn(actor);

		// Act
		ActorView actual = controller.getOne(2L);

		// Assert
		assertThat(actual.getId()).isEqualTo(2L);
		verify(actorRepo).findOne(2L);

	}

	@Test
	public void GetOne_returns_null_for_invalid_id() {
		// Arrange

		// Act
		ActorView actual = controller.getOne(1L);
		// Assert
		assertThat(actual).isNull();
		verify(actorRepo).findOne(1L);
	}

	@Test
	public void create_saves_actor_returns_actor() {
		// Arrange
		Actor actor = new Actor();
		when(actorRepo.save(actor)).thenReturn(actor);

		// Act
		Actor actual = controller.create(actor);

		// Assert
		assertThat(actual).isSameAs(actor);
		verify(actorRepo).save(actor);

	}

	@Test
	public void update_sets_id_of_actor_and_saves_actor() {
		// Arrange
		Actor actor = new Actor();
		when(actorRepo.save(actor)).thenReturn(actor);
		// Act
		Actor actual = controller.update(1L, actor);

		// Assert
		assertThat(actual).isSameAs(actor);
		assertThat(actual.getId()).isEqualTo(1L);
		verify(actorRepo).save(actor);
	}

	@Test
	public void delete_deletes_and_returns_actor() {
		// Arrange
		Actor actor = new Actor();
		when(actorRepo.findOne(1L)).thenReturn(actor);
		// Act
		Actor actual = controller.delete(1L);

		// Assert
		assertThat(actual).isSameAs(actor);
		verify(actorRepo).findOne(1L);
		verify(actorRepo).delete(1L);
	}

}
