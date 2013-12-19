package org.wei.spring.mvc.service;

import java.util.List;

import org.wei.spring.mvc.domain.Book;

public interface IBookService {
	
	public List<Book> findAll();
	public void addBook(Book book);
	public Book updateBook(Book book);
	public Book findById(Long id);
	public void securedMethod() ;

}
