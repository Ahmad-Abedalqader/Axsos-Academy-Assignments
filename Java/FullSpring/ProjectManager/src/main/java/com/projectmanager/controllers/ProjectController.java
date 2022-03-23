package com.projectmanager.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projectmanager.models.Project;
import com.projectmanager.models.User;
import com.projectmanager.services.ProjectService;
import com.projectmanager.services.UserService;

@Controller
public class ProjectController {
    
	@Autowired
	ProjectService projectService;
	@Autowired
	UserService userService;
    
	// Dashboard
    @GetMapping ("/dashboard")
    public String bookMarket(Model model, HttpSession session){
    	if (session.getAttribute("userId")!= null){
    		Long userId = (Long) session.getAttribute("userId");
    		User currentUser = userService.findUserById(userId);
    		model.addAttribute("currentUser", currentUser);
    		
        	List<Project> allProjects = projectService.allProjects();
        	ArrayList<Project> unInvolvedProjects = new ArrayList<Project>();
        	for (Project project: allProjects) {
        		if (!project.getUsers().contains(currentUser)) {
        			unInvolvedProjects.add(project);
        		}
        	}
        	
        	model.addAttribute("unInvolvedProjects", unInvolvedProjects);
    		return "Dashboard.jsp";
    	}
    	return "redirect:/";
    	  		
    }
  
    // Project Details
    @RequestMapping("/projects/{id}")
    public String showProject(Model model, @PathVariable("id") Long id, HttpSession session) {
    	if (session.getAttribute("userId")!= null){
    		Long userId = (Long) session.getAttribute("userId");
			User currentUser = userService.findUserById(userId);
			model.addAttribute("currentUser", currentUser);
			
	        Project project = projectService.findProject(id);
	        model.addAttribute("project", project);
	        return "ProjectDetails.jsp";
    	}
    	return "redirect:/";
    }
    
    // adding new Project "Get Method"
    @GetMapping("/projects/new")
    public String index( @ModelAttribute("project") Project project, HttpSession session) {
    	if (session.getAttribute("userId")!= null){
    		return "AddProject.jsp";
    	}
    	return "redirect:/";
    }
    // adding new Project "Post Method"
    @PostMapping("/projects/new")
    public String addProject(@Valid @ModelAttribute("project") Project project, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "AddProject.jsp";
        } else {
        	Long id = (Long) session.getAttribute("userId");
        	User user = userService.findUserById(id);
        	projectService.createProject(project, user);
        	return "redirect:/dashboard";
        }
    }
    
    //Edit Project Get Method:
    @GetMapping("/projects/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
    	if (session.getAttribute("userId")!= null){
        Project project = projectService.findProject(id);
        model.addAttribute("project", project);
        return "Edit.jsp";
        
    	}else {
    		return "redirect:/";
    	}
    }
    
    //Edit Project Put Method:
    @PutMapping("/projects/{id}")
    public String update(@Valid @ModelAttribute("project") Project project, BindingResult result,
    					@PathVariable("id") Long id) {
        if (result.hasErrors()) {
            return "Edit.jsp";
        } else {
            projectService.updateProject(project, id);
            return "redirect:/dashboard";
        }
    }
    
    //join a project team:
    @GetMapping("/projects/{id}/join")
    public String join(@PathVariable("id") Long id, HttpSession session) {
    	
    	Long userId = (Long) session.getAttribute("userId");
    	User user = userService.findUserById(userId);
    	
    	Project project = projectService.findProject(id);
    	
    	projectService.joinProject(project, user);
        return "redirect:/dashboard";
    }
    
    //leave the project team:
    @GetMapping("/projects/{id}/leave")
    public String returnProject(@PathVariable("id") Long id, HttpSession session) {
    	
    	Long userId = (Long) session.getAttribute("userId");
    	User user = userService.findUserById(userId);
    	
    	Project project = projectService.findProject(id);
    	projectService.leaveProject(project, user);
        return "redirect:/dashboard";
    }
  
    //Delete a book:
    @DeleteMapping("/projects/{id}")
    public String destroy(@PathVariable("id") Long id) {
        projectService.deleteProject(id);
        return "redirect:/dashboard";
    }
    
    // Tasks Methods:
    //New Task Get Method:
    @GetMapping("/projects/{projectId}/tasks")
    public String task(HttpSession session, @PathVariable("projectId") Long id, Model model) {
    	
    	if (session.getAttribute("userId")!= null){
    
    		Project project = projectService.findProject(id);
    		model.addAttribute("project", project);
    		return "Tasks.jsp";
    	}
    	return "redirect:/";
    }
    
    @PostMapping("/projects/{projectId}/tasks")
    public String addTask( HttpSession session, @PathVariable("projectId") Long id,
    						Model model,@RequestParam("task") String task ) {
    	Long userId = (Long) session.getAttribute("userId");
    	User user = userService.findUserById(userId);
		Project project = projectService.findProject(id);
		
		projectService.addTask(user, project, task);
		
		return "redirect:/projects/"+id+"/tasks";
    }
    
}

