package org.wei.spring.mvc.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;
import org.wei.spring.mvc.domain.Book;
import org.wei.spring.mvc.domain.BookList;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

public class BooksPdfView extends AbstractPdfView {
	 
		@Override
		protected void buildPdfDocument(Map model, Document document,
			PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	 
			List<Book> books = ((BookList) model.get("books")).getBooks();
	 		    
			Table table = new Table(3);
						
			Cell c1 = new Cell(new Phrase("Id"));
		    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		    table.addCell(c1);
		    
		    Cell c2 = new Cell(new Phrase("Title"));
		    c2.setHorizontalAlignment(Element.ALIGN_CENTER);
		    table.addCell(c2);
		    
		    Cell c3 = new Cell(new Phrase("Author"));
		    c3.setHorizontalAlignment(Element.ALIGN_CENTER);
		    table.addCell(c3);
			
			for (Book book: books) {
				table.addCell(book.getId() + "");
				table.addCell(book.getTitle());
				table.addCell(book.getAuthor());
			}
			
			document.add(table);
		}
	}
