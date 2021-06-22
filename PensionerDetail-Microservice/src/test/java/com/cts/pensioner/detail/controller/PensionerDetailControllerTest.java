package com.cts.pensioner.detail.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.cts.pensioner.detail.feignclient.AuthorisingClient;


@AutoConfigureMockMvc
@SpringBootTest
public class PensionerDetailControllerTest {

	
	
	
	@MockBean
	private AuthorisingClient authorisingClient;
	
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void testClientNotNull() {
		assertThat(authorisingClient).isNotNull();
	}
	
	@Test
	void testMockMvcNotNull() {
		assertThat(mockMvc).isNotNull();
	}

	
	  @Test 
	  void testGetResponse() throws Exception
	  {
		  when(authorisingClient.authorizeTheRequest("Bearer @token@token")).thenReturn(true);
		  mockMvc.perform(get("/api/v1/PensionerDetailByAadhaar/420559429029").header("Authorization", "Bearer @token@token"))
				.andExpect(status().isOk());
	  }
	  
	  @Test 
	  void testGetResponseWrongAuthorization() throws Exception
	  {
		  when(authorisingClient.authorizeTheRequest("Bearer @token@token")).thenReturn(false);
		  mockMvc.perform(get("/api/v1/PensionerDetailByAadhaar/420559429029").header("Authorization", "Bearer @token@token"))
				.andExpect(status().isForbidden());
	  }
	  @Test 
	  void testGetResponseAadharNotFound() throws Exception
	  {
		  when(authorisingClient.authorizeTheRequest("Bearer @token@token")).thenReturn(true);
		  mockMvc.perform(get("/api/v1/PensionerDetailByAadhaar/420559429020").header("Authorization", "Bearer @token@token"))
				.andExpect(status().isNotFound());
	  }
	  
	  @Test 
	  void testGetResponseBadRequest() throws Exception
	  {
		  //when(authorisingClient.authorizeTheRequest("Bearer @token@token")).thenReturn(true);
		  mockMvc.perform(get("/api/v1/PensionerDetailByAadhaar/420559429029")).andExpect(status().isBadRequest());
	  }

	  @Test 
	  void testGetAllPensioner() throws Exception
	  {
		  when(authorisingClient.authorizeTheRequest("Bearer @token@token")).thenReturn(true);
		  mockMvc.perform(get("/api/v1/getAllPensioner").header("Authorization", "Bearer @token@token"))
				.andExpect(status().isOk());
	  }
	  
	  @Test 
	  void testGetAllPensionerWrongAuthorization() throws Exception
	  {
		  when(authorisingClient.authorizeTheRequest("Bearer @token@token")).thenReturn(false);
		  mockMvc.perform(get("/api/v1/getAllPensioner").header("Authorization", "Bearer @token@token"))
				.andExpect(status().isForbidden());
	  }
	  
	  @Test 
	  void testGetAllPensionerBadRequest() throws Exception
	  {
		//  when(authorisingClient.authorizeTheRequest("Bearer @token@token")).thenReturn(true);
		  mockMvc.perform(get("/api/v1/getAllPensioner"))
				.andExpect(status().isBadRequest());
	  }

	
}
