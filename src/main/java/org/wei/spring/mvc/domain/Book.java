package org.wei.spring.mvc.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {
	
	private long id;
	
	@NotNull
	@Size(min=3, max=50)
	private String title;
	
	@NotNull
	@Size(min=5, max=30)
	private String author;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public Book cloneBook() {
		Book book = new Book();
		book.setId(this.id);
		book.setAuthor(this.author);
		book.setTitle(this.title);
		return book;
	}
	
	@Override
	public String toString() {
		return String.format("Id: %d%nTitle: %s%nAuthor: %s", id, title, author);
	}
	
}
