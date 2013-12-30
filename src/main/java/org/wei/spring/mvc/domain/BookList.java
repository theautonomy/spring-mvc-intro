package org.wei.spring.mvc.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="books")
@XmlAccessorType(XmlAccessType.FIELD)
public class BookList {
    List<Book> bookslst;

	public List<Book> getBookslst() {
		return bookslst;
	}

	public void setBookslst(List<Book> bookslst) {
		this.bookslst = bookslst;
	}
}

