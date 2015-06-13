package org.wei.spring.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.wei.spring.mvc.domain.Book;
import org.wei.spring.mvc.repository.IBookRepository;

@Service("bookService")
public class BookServiceImpl implements IBookService {

	@Autowired
	@Qualifier("bookRepository")
	private IBookRepository bookRepository;
	
	@Override
	public List<Book> findAll() {		
		return bookRepository.findAll();
	}

	@Override
	public void addBook(Book book) {
		bookRepository.addBook(book);
	}

	@Override
	public Book updateBook(Book book) {	
		return bookRepository.updateBook(book);
	}

	@Override
	public Book findById(Long id) {
		return bookRepository.findById(id);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void securedMethod() {
		
	}

}
