package org.wei.spring.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.wei.spring.mvc.domain.Book;
import org.wei.spring.mvc.domain.BookList;
import org.wei.spring.mvc.service.IBookService;

@Controller
@RequestMapping(value = "/book")
public class BookController {

	private static final Logger logger = LoggerFactory.getLogger(BookController.class);

	@Autowired
	@Qualifier("bookService")
	private IBookService bookService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listBooks(Model model) {
		logger.info("Enter list all books page");
		List<Book> books = bookService.findAll();
		BookList bl = new BookList();
		bl.setBooks(books);
		model.addAttribute("books", bl);
		return "list";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editBookPage(@PathVariable Long id, Model model) throws Exception {
		Book book = bookService.findById(id);
		
		if (book == null) {
			throw new Exception("Book not found for id: " + id);
		}
		
		model.addAttribute("book", book);
		return "edit";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editBook(@ModelAttribute @Valid Book book, BindingResult result, @PathVariable Integer id,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return new ModelAndView("edit");
		}
		
		bookService.updateBook(book);
		return new ModelAndView("redirect:/book/list.html");
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView createBookPage() {
		ModelAndView mav = new ModelAndView("add", "book", new Book());
		//ModelAndView mav = new ModelAndView("add");  // This doesn't work
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	//public ModelAndView createBook(/*@ModelAttribute*/ @Valid Book book1,  // This works too
	public ModelAndView createBook(@ModelAttribute @Valid Book book1,
			BindingResult result, final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return new ModelAndView("add");
		}

		bookService.addBook(book1);
		return new ModelAndView("redirect:/book/list.html");
	}

	@RequestMapping(value = "/secret", method = RequestMethod.GET)
	public ModelAndView testMethodLevelSecurity() {
		bookService.securedMethod();
		ModelAndView mav = new ModelAndView("secret");
		return mav;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleError(HttpServletRequest req, Exception exception) {
	    logger.error("Request: " + req.getRequestURL() + " raised " + exception);

	    ModelAndView mav = new ModelAndView();
	    mav.addObject("exception", exception);
	    mav.addObject("url", req.getRequestURL());
	    mav.setViewName("error");
	    return mav;
	}
	
}
