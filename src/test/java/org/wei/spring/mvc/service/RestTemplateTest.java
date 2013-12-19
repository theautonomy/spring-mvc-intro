package org.wei.spring.mvc.service;

import java.net.MalformedURLException;

import org.junit.Test;
import static org.junit.Assert.*;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;
import org.wei.spring.mvc.domain.Book;

public class RestTemplateTest {
	
	@Test
	public void testCallJson() throws MalformedURLException {
		RestTemplate rt = new RestTemplate();	
		UriTemplate ut = new UriTemplate("http://localhost:8080/spring-mvc-intro/service/list/{id}.{format}");
		String url = ut.expand("10001", "json").toURL().toString();
		Book book = rt.getForObject(url, Book.class);
		assertEquals(10001L , book.getId());
	}
	
	@Test
	public void testCallXml() throws MalformedURLException {
		RestTemplate rt = new RestTemplate();	
		UriTemplate ut = new UriTemplate("http://localhost:8080/spring-mvc-intro/service/list/{id}.{format}");
		String url = ut.expand("10002", "xml").toURL().toString();
		Book book = rt.getForObject(url, Book.class);
		assertEquals(10002L , book.getId());
	}


}
