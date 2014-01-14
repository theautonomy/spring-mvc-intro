package org.wei.spring.mvc.view;

import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.supercsv.io.CsvBeanWriter;
import org.supercsv.prefs.CsvPreference;
import org.wei.spring.mvc.domain.Book;
import org.wei.spring.mvc.domain.BookList;

public class BooksCsvView extends AbstractCsvView {

	@Override
	protected void buildCsvDocument(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		CsvBeanWriter writer = new CsvBeanWriter(new OutputStreamWriter(response.getOutputStream()), CsvPreference.STANDARD_PREFERENCE); 
        writer.writeHeader("id", "title", "author");
        
        List<Book> books = ((BookList) model.get("books")).getBooks();
        
        for (Book book : books) {
        	writer.write(book, "id", "title","author");
        }
        
        writer.close();
	}

}
