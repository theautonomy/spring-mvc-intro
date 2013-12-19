package org.wei.spring.mvc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.wei.spring.mvc.domain.Book;

@Repository("bookRepository")
public class BookRepository implements IBookRepository {
		
	private static final List<Book> BOOKS = new ArrayList<Book>();
	
	static {
		Book book = new Book();
		book.setId(10001);
		book.setTitle("Diary of a Wimpy Kid: Hard Luck, Book 8");
		book.setAuthor("Jeff Kinney");
		BOOKS.add(book);
				
		book = new Book();
		book.setId(10002);
		book.setTitle("Big Nate: I Can't Take It!");
		book.setAuthor("Lincoln Peirce");
		BOOKS.add(book);
				
		book = new Book();
		book.setId(10003);
		book.setTitle("Laugh-Out-Loud Jokes for Kids");
		book.setAuthor("Rob Elliott");
		BOOKS.add(book);
				
		book = new Book();
		book.setId(10004);
		book.setTitle("TIME For Kids BIG Book of Why CRAZY, COOL & OUTRAGEOUS");
		book.setAuthor("Mark Shulman");
		BOOKS.add(book);
		
		book = new Book();
		book.setId(10005);
		book.setTitle("Super Incredible Knock-Knock Jokes for Kids");
		book.setAuthor("Super Incredible Knock-Knock Jokes for Kids");
		BOOKS.add(book);
	}
	
	@Override
	public List<Book> findAll() {	
		List<Book> books = new ArrayList<Book>(BOOKS.size());		
		for (Book book: BOOKS) {
			books.add(book);
		}
		return books;	
	}

	@Override
	public void addBook(Book book) {
		Book thisBook = BOOKS.get(BOOKS.size() -1);
		long id = thisBook.getId() + 1;
		book.setId(id);
		BOOKS.add(book);	
	}

    @Override
	public Book findById(Long id) {
		for (Book book: BOOKS) {
			if (id.equals(book.getId())) {
				return book;
			}
		}
		return null;
	}

	@Override
	public Book updateBook(Book book) {
		Book thisBook = findById(book.getId());
		thisBook.setTitle(book.getTitle());
		thisBook.setAuthor(book.getAuthor());
		return thisBook;
	}

}
