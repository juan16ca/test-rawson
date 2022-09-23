package com.nttdata.test.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.test.api.controller.ApiController;
import com.nttdata.test.api.model.entity.User;

@AutoConfigureMockMvc
@SpringBootTest
class ApiApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@InjectMocks
	private ApiController apiController;

	@Autowired
	MockHttpServletRequest request;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void validate() throws Exception {
		assertThat(apiController).isNotNull();
	}

	@Test
	void validateCode400() throws Exception {
		mockMvc.perform(get("/T/1015"))
				.andExpect(status().isBadRequest()).andReturn();
	}

	@Test
	void validateCode404() throws Exception {
		mockMvc.perform(get("/C/4789"))
				.andExpect(status().isNotFound()).andReturn();
	}

	@Test
	void validateCode500() throws Exception {
		mockMvc.perform(get("/C/1"))
				.andExpect(status().is(500)).andReturn();
	}

	@Test
	void validateCode200() throws Exception {

		var response = mockMvc.perform(get("/C/23445322"))
				.andExpect(status().isOk()).andReturn();

		var userFound = objectMapper.readValue(response.getResponse().getContentAsString(), User.class);

		assert userFound.getPrimerApellido().equalsIgnoreCase("Parra");
	}

}
