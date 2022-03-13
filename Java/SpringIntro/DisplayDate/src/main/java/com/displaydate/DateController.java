package com.displaydate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;

@Controller
public class DateController {
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	@RequestMapping("/date")
	public String date(Model model) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEEE,' the ' d ' of ' MMMM yyyy");  
		LocalDateTime now = LocalDateTime.now();
		model.addAttribute("date",dtf.format(now));
		return "Date.jsp";
	}
	@RequestMapping("/time")
	public String time(Model model) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("h:mm a"); 
		LocalDateTime now = LocalDateTime.now();
		model.addAttribute("time",dtf.format(now));
	
		return "Time.jsp";
	}
	

}
