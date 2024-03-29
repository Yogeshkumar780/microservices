package com.techprimers.stock.dbservice.model;

import java.util.List;

public class Quotes {

	private String userName;
	private List<String> quotes;

	public Quotes() {
		super();
	}

	public Quotes(String userName, List<String> quotes) {
		super();
		this.userName = userName;
		this.quotes = quotes;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<String> getQuotes() {
		return quotes;
	}

	public void setQuotes(List<String> quotes) {
		this.quotes = quotes;
	}

}
