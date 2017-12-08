package com.lmig.gfc.wimp.config;

import org.springframework.context.annotation.Configuration;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Award;
import com.lmig.gfc.wimp.models.Movie;
import com.lmig.gfc.wimp.services.ActorRepository;
import com.lmig.gfc.wimp.services.AwardRepository;
import com.lmig.gfc.wimp.services.MovieRepository;

@Configuration
public class SeedData {
	public SeedData(ActorRepository actorRepo, MovieRepository movieRepo, AwardRepository ar) {
		actorRepo.save(new Actor("lucille", "ball", (long) 1927, null));
		actorRepo.save(new Actor("Desi", "Arnaz", (long) 1941, null));
		movieRepo.save(new Movie("Gone With The Wind", null, (long) 3000000, "MGM"));
		movieRepo.save(new Movie("Titanic", null, (long) 200000000, "Paramount"));
		ar.save(new Award("Grammy", "ABC Org", 1953));
	}

}
