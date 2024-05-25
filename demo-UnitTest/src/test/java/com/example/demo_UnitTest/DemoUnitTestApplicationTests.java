package com.example.demo_UnitTest;

import com.example.demo_UnitTest.entities.User;
import com.example.demo_UnitTest.repositories.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@ActiveProfiles(value = "test")
@AutoConfigureMockMvc
class DemoUnitTestApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserRepository userRepository;
	

	@Test
	public void getAllUsers() throws Exception {
		List<User> users = new ArrayList<>();
		users.add(new User());
		users.add(new User());

		when(userRepository.findAll()).thenReturn(users);

		mockMvc.perform(get("/user/"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$").isArray())
				.andExpect(jsonPath("$.length()").value(users.size()));
	}

}





