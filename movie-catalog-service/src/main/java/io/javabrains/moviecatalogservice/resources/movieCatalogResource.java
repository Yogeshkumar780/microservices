package io.javabrains.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.javabrains.moviecatalogservice.model.CatalogItem;
import io.javabrains.moviecatalogservice.model.Movie;
import io.javabrains.moviecatalogservice.model.Rating;
import io.javabrains.moviecatalogservice.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class movieCatalogResource {

	@Autowired
	private RestTemplate template;
	
	@Autowired
	private WebClient.Builder webclientBuilder;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(String userid)
	{
		//WebClient.Builder builder=WebClient.builder();
		
	//	RestTemplate template =new RestTemplate();
		//template.getForObject("http://localhost:8082/movies/foo", Movie.class);
		
		UserRating userRating=template.getForObject("http://RATINGS-DATA-SERVICE/ratingdata/users/"+userid,
				UserRating.class);
		
		return userRating.getUserRating().stream().map(rating->{
		Movie movie=template.getForObject("http://MOVIE-INFO-SERVICE/movies/"+rating.getMovieId(), Movie.class);
		
		/* Movie movie=	webclientBuilder.build()
			.get()
			.uri("http://localhost:8082/movies/"+rating.getMovieId())
			.retrieve()
			.bodyToMono(Movie.class)
			.block(); */
			
			return new CatalogItem(movie.getMovieId(), "Test", rating.getRating());})
		.collect(Collectors.toList());
	
		/* 1.
		return Collections.singletonList(

				new CatalogItem("transformers", "Test", 3)
				);
				
				<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-client</artifactId>
			<spring-cloud.version>Greenwith.RELEASE</spring-cloud.version>
		</dependency>
		*/
	}
}
