package com.example.microservices.edurekauser.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.print.attribute.HashAttributeSet;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	public Map<String, String> map=new HashMap<String,String>();
	
	@PostConstruct
	public void init() {
		
		try {
			
			ParameterizedTypeReference<Map<String,String>> typeRef=new ParameterizedTypeReference<Map<String,String>>();
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

}
