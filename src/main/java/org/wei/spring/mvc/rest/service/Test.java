package org.wei.spring.mvc.rest.service;


import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;
import org.wei.spring.mvc.domain.Book;

public class Test {
	
	public static void main(String[] args) throws MalformedURLException {
		
		RestTemplate rt = new RestTemplate();
		
		UriTemplate ut = new UriTemplate("http://localhost:8080/spring-mvc-intro/service/list/{id}.{format}");
		
		String url = ut.expand("10001", "xml").toURL().toString();
		System.out.println("url=" + url);
		
		Book book = rt.getForObject(url, Book.class);
		System.out.println(book);
		
		
		Map<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("id", 10002);
		uriVariables.put("format", "json");
		
		url = ut.expand(uriVariables).toURL().toString();
		
		System.out.println("url=" + url);
		
		book = rt.getForObject(url, Book.class);
		System.out.println(book);
		
	}

}
