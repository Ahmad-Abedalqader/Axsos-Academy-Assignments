package com.dojo.omikujiform;

import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/omikuji")
public class Control {
	
	@RequestMapping("")
	public String index(HttpSession session, Model model) {
		
		return "Form.jsp";
	}
	@PostMapping("/formProcess")
	public String send(
		    @RequestParam(value="num") Integer num,
		    @RequestParam(value="city") String city,
		    @RequestParam(value="person") String person,
		    @RequestParam(value="hobby") String hobby,
		    @RequestParam(value="creature") String creature,
		    @RequestParam(value="saysomething") String saysomething,
		    HttpSession session) {
			
			session.setAttribute("num", num);
			session.setAttribute("city", city);
			session.setAttribute("person", person);
			session.setAttribute("hobby", hobby);
			session.setAttribute("creature", creature);
			session.setAttribute("saysomething", saysomething);
		    return "redirect:/omikuji/show";
		}
	@RequestMapping("/show")
	public String result(Model model, HttpSession session) {
		Integer num = (Integer) session.getAttribute("num");
		String city = (String) session.getAttribute("city");
		String person = (String) session.getAttribute("person");
		String hobby = (String) session.getAttribute("hobby");
		String creature = (String) session.getAttribute("creature");
		String saysomething = (String) session.getAttribute("saysomething");
		
		model.addAttribute("num", num);
		model.addAttribute("city", city);
		model.addAttribute("person", person);
		model.addAttribute("hobby", hobby);
		model.addAttribute("creature", creature);
		model.addAttribute("saysomething", saysomething);
		return "Result.jsp";
	}
	
	
}
