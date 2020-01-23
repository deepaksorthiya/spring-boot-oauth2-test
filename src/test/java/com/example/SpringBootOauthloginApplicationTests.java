package com.example;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.github.ahunigel.test.security.oauth2.MockTokenServices;
import com.github.ahunigel.test.security.oauth2.WithMockOAuth2Client;
import com.github.ahunigel.test.security.oauth2.WithMockOAuth2User;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@MockTokenServices
class SpringBootOauthloginApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Autowired
	private WebApplicationContext context;

	@Autowired
	private MockMvc mockMvc;

	@Test
	@WithMockOAuth2User(user = @WithMockUser, client = @WithMockOAuth2Client(approved = true, clientId = "client", scope = {
			"openid" }))
	void testUser() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().isOk());

	}

}
