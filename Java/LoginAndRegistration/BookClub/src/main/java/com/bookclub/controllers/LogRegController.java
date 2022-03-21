package com.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bookclub.models.LoginUser;
import com.bookclub.models.User;
import com.bookclub.services.UserService;

@Controller
public class LogRegController {
    // Add once service is implemented:
     @Autowired
     private UserService userServ;
    
    @GetMapping("/")
    public String index(Model model, HttpSession session) {
    	
    	if (session.getAttribute("userId")!= null){
    		return "redirect:/books";
    	}
    	
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "Forms.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        
    	User registeredUser = userServ.register(newUser, result);
        
        if(result.hasErrors()) {
            
            model.addAttribute("newLogin", new LoginUser());
            return "Forms.jsp";
        }
        session.setAttribute("userId", registeredUser.getId());
        return "redirect:/books";
      
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
    	
         User user = userServ.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "Forms.jsp";
        }
        
        session.setAttribute("userId", user.getId());
        return "redirect:/books";
    }
    
    
    @GetMapping ("/logout")
    public String logout(HttpSession session){
    	session.invalidate();
    	return "redirect:/";		
    }
    
}
