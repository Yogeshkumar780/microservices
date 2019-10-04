package com.techprimers.stock.dbservice.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techprimers.stock.dbservice.model.Quote;
import com.techprimers.stock.dbservice.model.Quotes;
import com.techprimers.stock.dbservice.repository.QuotesRepositiry;

@RestController
@RequestMapping("/rest/db")
public class DbServiceResource {
	
	//@Autowired
	private QuotesRepositiry repository;
	
	
	
	public DbServiceResource(QuotesRepositiry repositiry) {
	this.repository=repositiry;
	}

	@GetMapping("/{username}")
	public List<String> getQuotes(@PathVariable("username") String username){
		
		return getQuotesByUserName(username);
		
		
	}
	
	public List<String> getQuotesByUserName(String username)
	{
		return repository.findByUserName(username)
				.stream().map(Quote::getQuote)
				.collect(Collectors.toList());
	}
	
	@PostMapping("/add")
	public List<String> add(@RequestBody final Quotes quotes)
{
		quotes.getQuotes()
		.stream().map(quote->new Quote(quotes.getUserName(),quote))
		.forEach(quote->repository.save(quote));
		//quotes.getQuotes()
	//	.stream().forEach(quote->repository.save(new Quote(quotes.getUserName(),quote)));
		
		return getQuotesByUserName(quotes.getUserName());}
	
	@DeleteMapping("/{username}")
	public List<String> delete(@PathVariable("username") String username)
	{
		List<Quote> quotes=repository.findByUserName(username);
		repository.delete(quotes.get(0));
		return getQuotesByUserName(username);
		
	}
}
