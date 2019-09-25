package com.amit.git.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.amit.git.model.Project;
import com.amit.git.model.User;
import com.amit.git.service.GetData;
import com.amit.git.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;

@Component
@Api(value = "GitData")
@CrossOrigin
@RestController
public class BasicFrontController {
	
	@Autowired
	GetData getData;
	
	@Autowired
	UserService userservice;
	@ApiOperation(httpMethod = "GET", value = "Get all projects from both github and gitlab", response = Project.class, responseContainer = "List")
//    @ApiResponses(value = {
    //        @ApiResponse(code = 404, message = "Countries not found"),
    //        @ApiResponse(code = 500, message = "The countries could not be fetched")
  //  })    
	@GetMapping("/projects")
	public List<Project> getAllProject()
	{
		return getData.getAllProject();
	}
	
	@ApiOperation(httpMethod = "GET", value = "Get all Users from GitHub and GitLab", response = User.class, responseContainer = "List")
   @GetMapping("/users")
	public List<User> getAllUsers()
	{
		return userservice.getAllUsers();
	}

	@ApiOperation(httpMethod = "GET", value = "Get all Users from GitHub and GitLab", response = User.class, responseContainer = "List")
    @GetMapping("/user/{Uid}/project")
	public List<Project> getAllProjectForUser(@PathVariable("Uid") String loginid)
	{
		return userservice.getAllProjectByUserName(loginid);
	}
}
