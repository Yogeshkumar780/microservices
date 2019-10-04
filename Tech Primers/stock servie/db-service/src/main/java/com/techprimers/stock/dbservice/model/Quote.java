package com.techprimers.stock.dbservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "quote")
public class Quote {

	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "user_name")
	private String userName;
	private String quote;

	public Quote() {
		super();
	}

	public Quote(String userName, String quote) {
		super();
		this.userName = userName;
		this.quote = quote;
	}

	public Quote(Integer id, String userName, String quote) {
		super();
		this.id = id;
		this.userName = userName;
		this.quote = quote;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}
}
