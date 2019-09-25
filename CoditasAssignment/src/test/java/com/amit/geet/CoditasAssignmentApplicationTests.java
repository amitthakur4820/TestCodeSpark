package com.amit.geet;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.amit.git.controller.BasicFrontController;
import com.amit.git.model.Project;
import com.amit.git.service.GetData;
import com.amit.git.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
//@WebMvcTest(value=BasicFrontController.class,secure = false)
@SpringBootTest(classes = BasicFrontController.class)
public class CoditasAssignmentApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	

	@MockBean
	private GetData getData;
	@MockBean
	private UserService userService;


	
	@Test
	public void testGetAllProject() throws Exception {
		Project project1 = new Project();
		project1.setId(5);
		project1.sethtml_url("http://localhost:1313/git-repository-comb/user/amitthakur4820/project");
		project1.setName("TestProject One");
		project1.setSelf("");
		project1.setSource("GitHub");
		
		Project project2 = new Project();
		project2.setId(10);
		project2.sethtml_url("http://localhost:1313/git-repository-comb/user/amitthakur4820/project");
		project2.setName("TestProject two");
		project2.setSelf("");
		project2.setSource("Gitlab");

		
		List<Project> projectlist = new ArrayList<>();
		projectlist.add(project1);
		projectlist.add(project2);
		Mockito.when(getData.getAllProject()).thenReturn((projectlist));
		
		String URI = "/git-repository-comb/projects";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expectedJson = this.mapToJson(projectlist);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}
	
	
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
}
