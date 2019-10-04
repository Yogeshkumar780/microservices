package io.javabrains.movieinfoservice.Resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.javabrains.movieinfoservice.Model.Movie;
import io.javabrains.movieinfoservice.Model.MovieSummary;

@RestController
@RequestMapping("/movies")
public class MovieResource {

	@Value("$api.key")
	private String apiKey;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/{movieId}")
	public Movie getmovieInfo(@PathVariable("movieId") String movieId) {
		
		MovieSummary moviesummary=
		restTemplate.
		getForObject("https://api.themoviedb.org/3/movie/"+movieId+"?api_key="+apiKey, MovieSummary.class);
		return new Movie(movieId,moviesummary.getTitle(),moviesummary.getOverview());
		
		
	}
}
