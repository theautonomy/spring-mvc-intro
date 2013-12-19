package org.wei.spring.mvc.rest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wei.spring.mvc.controller.BookController;
import org.wei.spring.mvc.domain.Book;
import org.wei.spring.mvc.service.IBookService;

@Controller
@RequestMapping(value = "/service")
public class ServiceController {
	
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);

	@Autowired
	@Qualifier("bookService")
	private IBookService bookService;
	
	/*
	@RequestMapping(value = "/list/{id}.json", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Book listBookJson(@PathVariable Long id) {
		return bookService.findById(id);
	}

	@RequestMapping(value = "/list/{id}.xml", method = RequestMethod.GET,  produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public Book listBookXml(@PathVariable Long id) {
		return bookService.findById(id);
	}
	*/
	
	@RequestMapping(value = "/list/{id}", method = RequestMethod.GET,  produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public Book listBookBoth(@PathVariable Long id) {
		logger.info("Enter ");
		Book book = bookService.findById(id);
		return book;
	}
	}
