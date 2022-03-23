package com.projectmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectmanager.models.Project;
import com.projectmanager.models.Task;
import com.projectmanager.models.User;
import com.projectmanager.repositories.ProjectRepo;
import com.projectmanager.repositories.TaskRepo;
import com.projectmanager.repositories.UserRepository;

@Service
public class ProjectService {
	
	 
	@Autowired
	private ProjectRepo projectRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private TaskRepo taskRepo;
	 
	 
	 // returns all the projects
	 public List<Project> allProjects() {
	     return projectRepo.findAll();
	 }
	 
	 // creates a project
	 public void createProject(Project project, User user) {
		 projectRepo.save(project);
		 user.getProjects().add(project);
		 project.setTeamLead(user);
		 userRepo.save(user);
	 }
	 
	 // retrieves a project
	 public Project findProject(Long id) {
	     Optional<Project> optionalProject = projectRepo.findById(id);
	     if(optionalProject.isPresent()) {
	         return optionalProject.get();
	     } else {
	         return null;
	     }
	 }
	 //Update
	 public Project updateProject(Project newProject, Long projectId) {
		
		 Optional<Project> optionalProject = projectRepo.findById(projectId);
	     if(optionalProject.isPresent()) {
	         Project project = optionalProject.get();
	         project.setTitle(newProject.getTitle());
	         project.setDescription(newProject.getDescription());
		     project.setDueDate(newProject.getDueDate()); 
	     	 
		     return projectRepo.save(project);
	     }
	     return null;
	 }
	 //join the project team
	 public Project joinProject(Project project, User user) {
		 project.getUsers().add(user);
		return projectRepo.save(project);
	 }
	 //Leave the project team
	 public Project leaveProject(Project project, User user) {
		 project.getUsers().remove(user);
		return projectRepo.save(project);
	 }
	 //Delete the project
	 public void deleteProject(Long id) {
		projectRepo.deleteById(id);
	}
	 
	 //Adding Task:
	 public void addTask(User user, Project project, String task) {
		 
		Task mytask = new Task();
		mytask.setTask(task);
		mytask.setAddedBy(user);
		mytask.setProject(project);
		
		taskRepo.save(mytask);
		
	}
	 
}

