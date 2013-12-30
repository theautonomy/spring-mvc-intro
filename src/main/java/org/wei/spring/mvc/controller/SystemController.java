package org.wei.spring.mvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SystemController {
	
	//private static final Logger logger = LoggerFactory.getLogger(SystemController.class);

	@RequestMapping(value={"/", "index"}, method=RequestMethod.GET)
	public ModelAndView index(Locale locale) {		
		ModelAndView mav = new ModelAndView("index");		
		mav.addObject("time", getLocalTime(locale));	
		return mav;
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}
	
	@RequestMapping(value="/unavailable", method = RequestMethod.GET)
	public String unavailable(Model model, Locale locale) {
		model.addAttribute("time", getLocalTime(locale));
		return "unavailable";
	}
	
	private String getLocalTime(Locale locale) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);		
		return dateFormat.format(date);		
	}
	
	/*
	@RequestMapping(value="/error", method = RequestMethod.GET)
	public String error(Model model) {
		return "error";
	}
	*/
}
