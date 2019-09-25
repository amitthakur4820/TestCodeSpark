package com.amit.git.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.amit.git.model.Project;
import com.amit.git.model.User;

@Service
public class UserService {
	RestTemplate restTemplate = new RestTemplate();
	final private String Github_Access_token ="f650350bc65f4729e5566d0bc00014ebfea9b00b";
	final private String GitLab_Access_token ="h26Lyp6vUp7JTszwqHkU";
	public List<User> getAllUsers() {
		String github = "https://api.github.com/users?access_token="+Github_Access_token;
		String gitlib = "https://gitlab.com/api/v4/users?access_token="+GitLab_Access_token;

		User[] responsegit = restTemplate.getForObject(github, User[].class);
		User[] responselib = restTemplate.getForObject(gitlib, User[].class);

		User[] response = new User[responsegit.length + responselib.length];

		System.arraycopy(responsegit, 0, response, 0, responsegit.length);
		System.arraycopy(responselib, 0, response, responsegit.length, responselib.length);
		for (int i = 0; i < response.length; i++) {
			if (i < responsegit.length)
				response[i].setSource("GitHub");
			else
				response[i].setSource("GitLab");
		}
		return Arrays.asList(response);
	}
	
	public List<Project> getAllProjectByUserName(String uname) {
		String githuburl = "https://api.github.com/users/" + uname + "/repos";
		String gitliburl = "https://gitlab.com/api/v4/users/" + uname + "/projects";

		Project[] responsegit = restTemplate.getForObject(githuburl, Project[].class);
		Project[] responselib = restTemplate.getForObject(gitliburl, Project[].class);
		Project[] response = new Project[responsegit.length + responselib.length];

		System.arraycopy(responsegit, 0, response, 0, responsegit.length);
		System.arraycopy(responselib, 0, response, responsegit.length, responselib.length);
		for (int i = 0; i < response.length; i++) {
			if (i < responsegit.length)
				response[i].setSource("GitHub");
			else
				response[i].setSource("GitLab");
		}
		return Arrays.asList(response);
	}
}
