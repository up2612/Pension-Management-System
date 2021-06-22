package com.cts.pension.disbursement.controller;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.cts.pension.disbursement.exception.AadharNumberNotFound;

import com.cts.pension.disbursement.feignclient.AuthorisingClient;
import com.cts.pension.disbursement.feignclient.PensionDisbursementFeignClient;
import com.cts.pension.disbursement.model.PensionerDetail;
import com.cts.pension.disbursement.model.ProcessPensionInput;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@SpringBootTest
public class PensionDisbursementControllerTest {

	
	@MockBean
	private AuthorisingClient authorisingClient;
	
	@MockBean
	PensionDisbursementFeignClient pensionDisbursementFeignClient;
	
	@Autowired
	private MockMvc mockMvc;
	  
	  
	@Test
	void testClientNotNull() {
			assertThat(authorisingClient).isNotNull();
		}
	
	@Test
	void testpensionDisbursementFeignClient() {
			assertThat(pensionDisbursementFeignClient).isNotNull();
		}
		
	@Test
	void testMockMvcNotNull() {
			assertThat(mockMvc).isNotNull();
		}
	  
	  
	  String mapToJson(Object object) throws JsonProcessingException {
	        ObjectMapper objectMapper = new ObjectMapper();
	        return objectMapper.writeValueAsString(object);
	    }
		  
	  
	  
	  
	  
	@Test 
	void testGetResponse() throws Exception {
		
		when(authorisingClient.authorizeTheRequest("Bearer @token@token")).thenReturn(true);
		PensionerDetail pensionerDetail = new PensionerDetail(420559429029l, "Parthik", LocalDate.of(1999, 12, 03), "BSDPS1495K", 29000, 1200, "self", "SBI", "9029486523", "private");
		when(pensionDisbursementFeignClient.getPensionerDetailByAadhaar("Bearer @token@token", 420559429029l)).thenReturn(pensionerDetail);
		ProcessPensionInput processPensionInput = new ProcessPensionInput(420559429029l, 24400.0, 550);
		String jsonPensionerInput = this.mapToJson(processPensionInput);
		mockMvc.perform(post("/api/v1/disbursePension").contentType("application/json").content(jsonPensionerInput).header("Authorization", "Bearer @token@token"))
		.andExpect(status().isOk());
	}
	
	 @Test
     void testGetResponseInvalidAuthorization() throws Exception {
        when(authorisingClient.authorizeTheRequest("InvalidToken")).thenReturn(false);
        ProcessPensionInput processPensionInput = new ProcessPensionInput(420559429029l, 24400.0, 550);
		String jsonPensionerInput = this.mapToJson(processPensionInput);
        mockMvc.perform(post("/api/v1/disbursePension").contentType("application/json").content(jsonPensionerInput).header("Authorization", "InvalidToken")).
        		andExpect(status().isForbidden());
        
    }
	 
	 @Test
		void testGetResponseWithoutHeader() throws Exception {

		 ProcessPensionInput processPensionInput = new ProcessPensionInput(420559429029l, 24400.0, 550);
			String jsonPensionerInput = this.mapToJson(processPensionInput);
	    	mockMvc.perform(post("/api/v1/disbursePension").contentType("application/json").content(jsonPensionerInput)).andExpect(status().isBadRequest());

		}
	 
	 @Test
		void testGetResponseInvalidAadharCard() throws Exception {

		 when(authorisingClient.authorizeTheRequest("Bearer @token@token")).thenReturn(true);
	
			when(pensionDisbursementFeignClient.getPensionerDetailByAadhaar("Bearer @token@token", 420559429029l)).thenThrow(AadharNumberNotFound.class);
			ProcessPensionInput processPensionInput = new ProcessPensionInput(420559429029l, 24400.0, 550);
			String jsonPensionerInput = this.mapToJson(processPensionInput);
			mockMvc.perform(post("/api/v1/disbursePension").contentType("application/json").content(jsonPensionerInput).header("Authorization", "Bearer @token@token"))
			.andExpect(status().isNotFound());

		}
	

	
}
