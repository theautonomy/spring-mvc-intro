package org.wei.spring.mvc.repository;

import java.util.List;

import org.wei.spring.mvc.domain.Book;

public interface IBookRepository {
	
	public List<Book> findAll();
	public void addBook(Book book);
	public Book updateBook(Book book);
	public Book findById(Long id);

}
