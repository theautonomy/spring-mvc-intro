package org.wei.spring.mvc.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wei.spring.mvc.domain.Book;
import org.wei.spring.mvc.service.IBookService;

@Controller
@RequestMapping(value = "/service")
public class ServiceController {

	@Autowired
	@Qualifier("bookService")
	private IBookService bookService;
	
	@RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Book listBookBoth(@PathVariable Long id) {
		Book book = bookService.findById(id);
		return book;
	}
	}
