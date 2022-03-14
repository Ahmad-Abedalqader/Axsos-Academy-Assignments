package com.dojo.ninjagold;

import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Gold")
public class NinjaGoldController {
	
	@RequestMapping("")
	public String index(HttpSession session, Model model) {
		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}

		if (session.getAttribute("activity") == null) {
			ArrayList<String> activities = new ArrayList<String>();
			session.setAttribute("activity", activities);
		}
		model.addAttribute("gold", session.getAttribute("gold"));
		model.addAttribute("activity", session.getAttribute("activity"));
		return "NinjaGold.jsp";
	}
	@PostMapping("/formProcess")
	public String check(
		    @RequestParam(value="which") String which,
		    HttpSession session) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM d yyyy h:mm a");  
		LocalDateTime now = LocalDateTime.now();
		
		if (which.equals("farm")) {
			Random rand = new Random();
			Integer random = rand.nextInt((20 - 10) + 1) + 10;
			Integer gold = (Integer) session.getAttribute("gold");
			gold += random;
			session.setAttribute("gold", gold);
			ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activity");	
			activities.add("Earned "+ random + " golds from the farm! " +"("+ dtf.format(now) +")");
			session.setAttribute("activity", activities);
		}
		else if (which.equals("cave")) {
			Random rand = new Random();
			Integer random = rand.nextInt((10 - 5) + 1) + 5;
			Integer gold = (Integer) session.getAttribute("gold");
			gold += random;
			session.setAttribute("gold", gold);
			ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activity");	
			activities.add("Earned "+ random + " golds from the farm! " +"("+ dtf.format(now) +")");
			session.setAttribute("activity", activities);
			
		}
		else if (which.equals("house")) {
			Random rand = new Random();
			Integer random = rand.nextInt((5 - 2) + 1) + 2;
			Integer gold = (Integer) session.getAttribute("gold");
			gold += random;
			session.setAttribute("gold", gold);
			ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activity");	
			activities.add("Earned "+ random + " golds from the farm! " +"("+ dtf.format(now) +")");
			session.setAttribute("activity", activities);
			
		}
		else if (which.equals("quest")) {
			Random rand = new Random();
			Integer random = rand.nextInt(101) - 50;
			Integer gold = (Integer) session.getAttribute("gold");
			gold += random;
			session.setAttribute("gold", gold);
			ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activity");
			if (random<0) {
				activities.add("You failed a quest and Lost  "+ Math.abs(random) + " golds. " +"("+ dtf.format(now) +")");
			}
			else {
				activities.add("You completed a quest and Earned  "+ random + " golds. " +"("+ dtf.format(now) +")");
			}
			
			session.setAttribute("activity", activities);
			
		}
		
	    return "redirect:/Gold";
	}
	
	
}
