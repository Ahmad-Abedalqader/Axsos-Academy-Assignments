package com.dojo.counter;

import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Counter {
	@RequestMapping("")
	public String index(HttpSession session, Model model) {
		
    	// If the count is not already in session
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			Integer currentCount = (Integer) session.getAttribute("count");
			currentCount++;
			session.setAttribute("count", currentCount);
			model.addAttribute("count", currentCount);
		}
		return "Home.jsp";
	}
	@RequestMapping("/counter")
	public String count() {
		return "Counter.jsp";
	}
	
	
}
