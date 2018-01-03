package com.lmig.gfc.wimp.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*")
@RequestMapping("/api/actors")
public class ActorsApiController {
	private ActorRepository actorRepo;

	public ActorsApiController(ActorRepository a) {
		actorRepo = a;
	}

	@GetMapping("")
	public List<ActorView> getAll() {
		ArrayList<ActorView> av = new ArrayList<ActorView>();
		for (Actor actor : actorRepo.findAll()) {
			av.add(new ActorView(actor));
		}
		return av;
	}

	@GetMapping("{id}")
	public ActorView getOne(@PathVariable Long id) {
		ActorView av = null;
		Actor actor = actorRepo.findOne(id);
		if (actor != null) {
			av = new ActorView(actor);
		}
		return av;

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
		Actor actor = actorRepo.findOne(id);
		// This call accesses the db and creates a session so the actor can return
		// actor.getAwards().contains(null);
		actorRepo.delete(id);
		return actor;

	}
}
