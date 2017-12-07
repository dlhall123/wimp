package com.lmig.gfc.wimp.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.services.ActorRepository;

@RestController
@RequestMapping("/api/actors")
public class ActorsApiController {
	private ActorRepository actorRepo;

	public ActorsApiController(ActorRepository a) {
		actorRepo = a;
	}

	@GetMapping("")
	public List<Actor> getAll() {
		return actorRepo.findAll();
	}

	@GetMapping("{id}")
	public Actor getOne(@PathVariable Long id) {
		return actorRepo.findOne(id);

	}

	@PostMapping("")
	public Actor create(@RequestBody Actor actor) {
		return actorRepo.save(actor);
	}

	@PutMapping("{id}")
	public Actor update(@PathVariable Long id, @RequestBody Actor actor) {
		actor.setId(id);
		return actorRepo.save(actor);
	}

	@DeleteMapping("{id}")
	public Actor delete(@PathVariable Long id) {
		Actor actor = actorRepo.getOne(id);
		actorRepo.delete(id);
		return actor;

	}
}
