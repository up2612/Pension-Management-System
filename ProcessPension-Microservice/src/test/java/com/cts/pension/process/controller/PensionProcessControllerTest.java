package com.cts.pension.process.controller;



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

import com.cts.pension.process.exception.AadharNumberNotFound;
import com.cts.pension.process.feignclient.AuthorisingClient;
import com.cts.pension.process.feignclient.PensionDisbursementFeignClient;
import com.cts.pension.process.feignclient.PensionerDetailFeignClient;
import com.cts.pension.process.model.PensionerDetail;
import com.cts.pension.process.model.PensionerInput;
import com.cts.pension.process.model.ProcessPensionInput;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@AutoConfigureMockMvc
@SpringBootTest
public class PensionProcessControllerTest {
	
	@MockBean
	private AuthorisingClient authorisingClient;
	
	@MockBean
	private PensionerDetailFeignClient pensionerDetailFeignClient;
	
	@MockBean
	private PensionDisbursementFeignClient pensionDisbursementFeignClient;
	
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	void testClientNotNull() {
		assertThat(authorisingClient).isNotNull();
	}
	
	@Test
	void testpensionerDetailFeignClient() {
		assertThat(pensionerDetailFeignClient).isNotNull();
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
		void testGetprocessingCode() throws Exception {
			
			when(authorisingClient.authorizeTheRequest("Bearer @token@token")).thenReturn(true);
			ProcessPensionInput processPensionInput = new ProcessPensionInput(420559429029l, 24400.0, 550);
			String jsonPensionerInput = this.mapToJson(processPensionInput);
			mockMvc.perform(post("/api/v1/ProcessPension").contentType("application/json").content(jsonPensionerInput).header("Authorization", "Bearer @token@token"))
			.andExpect(status().isOk());
		}
	  @Test 
		void testGetprocessingCodeInvalidToken() throws Exception {
			
			when(authorisingClient.authorizeTheRequest("Bearer @token@token")).thenReturn(false);
			ProcessPensionInput processPensionInput = new ProcessPensionInput(420559429029l, 24400.0, 550);
			String jsonPensionerInput = this.mapToJson(processPensionInput);
			mockMvc.perform(post("/api/v1/ProcessPension").contentType("application/json").content(jsonPensionerInput).header("Authorization", "Bearer @token@token"))
			.andExpect(status().isForbidden());
		}
	  
	  @Test
		void testGetResponseInvalidAadharCard() throws Exception {

		 when(authorisingClient.authorizeTheRequest("Bearer @token@token")).thenReturn(true);
			ProcessPensionInput processPensionInput = new ProcessPensionInput(420559429020l, 24400.0, 550);
			String jsonPensionerInput = this.mapToJson(processPensionInput);
			mockMvc.perform(post("/api/v1/disbursePension").contentType("application/json").content(jsonPensionerInput).header("Authorization", "Bearer @token@token"))
			.andExpect(status().isNotFound());

		}
	  
	  
	  @Test 
		void testGetResponse() throws Exception {
			
			when(authorisingClient.authorizeTheRequest("Bearer @token@token")).thenReturn(true);
			PensionerDetail pensionerDetail = new PensionerDetail(420559429029l, "Parthik", LocalDate.of(1999, 12, 03), "BSDPS1495K", 29000, 1200, "self", "SBI", "9029486523", "private");
			when(pensionerDetailFeignClient.getPensionerDetailByAadhaar("Bearer @token@token", 420559429029l)).thenReturn(pensionerDetail);
			PensionerInput pensionerInput = new PensionerInput();
			pensionerInput.setAadharNumber(420559429029l);
			pensionerInput.setName("Parthik");
			pensionerInput.setPan("BSDPS1495K");
			pensionerInput.setPensionType("self");
			String jsonPensionerInput = this.mapToJson(pensionerInput);
			mockMvc.perform(post("/api/v1/PensionDetail").contentType("application/json").content(jsonPensionerInput).header("Authorization", "Bearer @token@token"))
			.andExpect(status().isOk());
		}
	  @Test 
	  void testGetPensionDetail() throws Exception {
				
				when(authorisingClient.authorizeTheRequest("Bearer @token@token")).thenReturn(true);
				PensionerDetail pensionerDetail = new PensionerDetail(420559429029l, "Parthik", LocalDate.of(1999, 12, 03), "BSDPS1495K", 29000, 1200, "self", "SBI", "9029486523", "private");
				when(pensionerDetailFeignClient.getPensionerDetailByAadhaar("Bearer @token@token", 420559429029l)).thenReturn(pensionerDetail);
				PensionerInput pensionerInput = new PensionerInput();
				pensionerInput.setAadharNumber(420559429029l);
				pensionerInput.setName("Parthik");
				pensionerInput.setPan("BSDPS1495K");
				pensionerInput.setPensionType("self");
				String jsonPensionerInput = this.mapToJson(pensionerInput);
				mockMvc.perform(post("/api/v1/PensionDetail").contentType("application/json").content(jsonPensionerInput).header("Authorization", "Bearer @token@token"))
				.andExpect(status().isOk());
			}
	  
	  
	  	@Test 
		void testGetPensionDetailNotAuthorized() throws Exception {
				
				when(authorisingClient.authorizeTheRequest("Bearer @token@token")).thenReturn(false);
				PensionerDetail pensionerDetail = new PensionerDetail(420559429029l, "Parthik", LocalDate.of(1999, 12, 03), "BSDPS1495K", 29000, 1200, "self", "SBI", "9029486523", "private");
				when(pensionerDetailFeignClient.getPensionerDetailByAadhaar("Bearer @token@token", 420559429029l)).thenReturn(pensionerDetail);
				PensionerInput pensionerInput = new PensionerInput();
				pensionerInput.setAadharNumber(420559429029l);
				pensionerInput.setName("Parthik");
				pensionerInput.setPan("BSDPS1495K");
				pensionerInput.setPensionType("self");
				String jsonPensionerInput = this.mapToJson(pensionerInput);
				mockMvc.perform(post("/api/v1/PensionDetail").contentType("application/json").content(jsonPensionerInput).header("Authorization", "Bearer @token@token"))
				.andExpect(status().isForbidden());
			}
	  	
		@Test 
		void testGetPensionDetailBadRequest() throws Exception {
				
				//when(authorisingClient.authorizeTheRequest("Bearer @token@token")).thenReturn(true);
				PensionerDetail pensionerDetail = new PensionerDetail(420559429029l, "Parthik", LocalDate.of(1999, 12, 03), "BSDPS1495K", 29000, 1200, "self", "SBI", "9029486523", "private");
				when(pensionerDetailFeignClient.getPensionerDetailByAadhaar("Bearer @token@token", 420559429029l)).thenReturn(pensionerDetail);
				PensionerInput pensionerInput = new PensionerInput();
				pensionerInput.setAadharNumber(420559429029l);
				pensionerInput.setName("Parthik");
				pensionerInput.setPan("BSDPS1495K");
				pensionerInput.setPensionType("self");
				String jsonPensionerInput = this.mapToJson(pensionerInput);
				mockMvc.perform(post("/api/v1/PensionDetail").contentType("application/json").content(jsonPensionerInput)).andExpect(status().isBadRequest());
			}
		
		@Test 
		void testGetPensionDetailAadharCard() throws Exception {
				
				when(authorisingClient.authorizeTheRequest("Bearer @token@token")).thenReturn(true);
				when(pensionerDetailFeignClient.getPensionerDetailByAadhaar("Bearer @token@token", 420559429029l)).thenThrow(AadharNumberNotFound.class);
				PensionerInput pensionerInput = new PensionerInput();
				pensionerInput.setAadharNumber(420559429029l);
				pensionerInput.setName("Parthik");
				pensionerInput.setPan("BSDPS1495K");
				pensionerInput.setPensionType("self");
				String jsonPensionerInput = this.mapToJson(pensionerInput);
				mockMvc.perform(post("/api/v1/PensionDetail").contentType("application/json").content(jsonPensionerInput).header("Authorization", "Bearer @token@token"))
				.andExpect(status().isNotFound());
			}
		@Test 
		void testGetPensionDetailPensionerDetailNotFound() throws Exception {
				
				when(authorisingClient.authorizeTheRequest("Bearer @token@token")).thenReturn(true);
				PensionerDetail pensionerDetail = new PensionerDetail(420559429029l, "Parthik", LocalDate.of(1999, 12, 03), "BSDPS1495K", 29000, 1200, "self", "SBI", "9029486523", "private");
				when(pensionerDetailFeignClient.getPensionerDetailByAadhaar("Bearer @token@token", 420559429029l)).thenReturn(pensionerDetail);
				PensionerInput pensionerInput = new PensionerInput();
				pensionerInput.setAadharNumber(420559429029l);
				pensionerInput.setName("Shubham");
				pensionerInput.setPan("BSDPS1495K");
				pensionerInput.setPensionType("self");
				String jsonPensionerInput = this.mapToJson(pensionerInput);
				mockMvc.perform(post("/api/v1/PensionDetail").contentType("application/json").content(jsonPensionerInput).header("Authorization", "Bearer @token@token"))
				.andExpect(status().isNotFound());
			}
}
