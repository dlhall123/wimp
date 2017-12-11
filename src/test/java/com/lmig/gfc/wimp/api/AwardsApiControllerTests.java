package com.lmig.gfc.wimp.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Award;
import com.lmig.gfc.wimp.services.ActorRepository;
import com.lmig.gfc.wimp.services.AwardRepository;

public class AwardsApiControllerTests {
	private AwardsApiController controller;
	private ActorRepository acr;
	private AwardRepository awr;

	public AwardsApiControllerTests() {
		acr = mock(ActorRepository.class);
		awr = mock(AwardRepository.class);
		controller = new AwardsApiController(acr, awr);
	}

	@Test
	public void create_adds_award_with_actor() {
		// Arrange
		Award award = new Award();
		Actor actor = new Actor();
		when(acr.findOne(1L)).thenReturn(actor);
		// Act
		Award actual = controller.create(1L, award);
		// Assert
		assertThat(actual.getActor()).isSameAs(actor);
		verify(awr).save(award);
		verify(acr).findOne(1L);
		assertThat(actual).isSameAs(award);
	}

}
