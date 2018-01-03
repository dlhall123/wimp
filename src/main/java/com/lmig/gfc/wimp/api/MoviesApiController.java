package com.lmig.gfc.wimp.api;

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

import com.lmig.gfc.wimp.models.Movie;
import com.lmig.gfc.wimp.services.MovieRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/movies")
public class MoviesApiController {
	MovieRepository movieRepo;

	public MoviesApiController(MovieRepository mr) {
		movieRepo = mr;
	}

	@GetMapping("")
	public List<Movie> getAll() {
		return movieRepo.findAll();
	}

	@GetMapping("{id}")
	public Movie getOne(@PathVariable Long id) {
		return movieRepo.findOne(id);
	}

	@PostMapping("")
	public Movie create(@RequestBody Movie movie) {
		System.out.println(movie.getReleaseDate());
		return movieRepo.save(movie);
	}

	@PutMapping("{id}")
	public Movie update(@PathVariable Long id, @RequestBody Movie movie) {
		movie.setId(id);
		return movieRepo.save(movie);
	}

	@DeleteMapping("{id}")
	public Movie delete(@PathVariable Long id) {
		Movie deleted = movieRepo.findOne(id);
		movieRepo.delete(id);
		return deleted;
	}

}
