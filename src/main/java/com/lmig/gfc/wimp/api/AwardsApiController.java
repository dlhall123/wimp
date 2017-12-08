package com.lmig.gfc.wimp.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Award;
import com.lmig.gfc.wimp.services.ActorRepository;
import com.lmig.gfc.wimp.services.AwardRepository;

@RestController
@RequestMapping("/api/actors/{actorId}/awards")
public class AwardsApiController {
	ActorRepository acr;
	AwardRepository awr;

	public AwardsApiController(ActorRepository acr, AwardRepository awr) {
		this.acr = acr;
		this.awr = awr;
	}

	@PostMapping("")
	public Award create(@PathVariable Long actorId, @RequestBody Award award) {
		Actor actor = acr.findOne(actorId);
		award.setActor(actor);
		awr.save(award);
		return award;

	}

}
