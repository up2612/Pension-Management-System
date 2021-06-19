package com.cts.pension.disbursement.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.pension.disbursement.exception.AadharNumberNotFound;
import com.cts.pension.disbursement.exception.AuthorizationException;
import com.cts.pension.disbursement.feignclient.AuthorisingClient;
import com.cts.pension.disbursement.feignclient.PensionDisbursementFeignClient;
import com.cts.pension.disbursement.model.PensionerDetail;
import com.cts.pension.disbursement.model.ProcessPensionInput;
import com.cts.pension.disbursement.model.ProcessPensionResponse;
import com.cts.pension.disbursement.service.PensionDisbursementServiceImpl;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class PensionDisbursementControllerTest {

	
	@InjectMocks
	private PensionDisbursementServiceImpl pensionDisbursementServiceImpl;
	
	@InjectMocks
	private PensionDisbursementController pensionDisbursementController;
	
	@Mock
	private AuthorisingClient authorisingClient;
	
	@Mock
	private  PensionDisbursementFeignClient pensionDisbursementFeignClient;
	
	@Mock
	private ProcessPensionResponse responce;
	
	@Test
	public void testControllerObjectNotNull() {
		assertNotNull(pensionDisbursementController);
	}
	
	@Test
	public void testServiceObjectNotNull() {
		assertNotNull(pensionDisbursementServiceImpl);
	}
	
	@Test
	public void testResponseObjectNotNull() {
		assertNotNull(responce);
	}
	
	@Test
	public void testResponce() throws AuthorizationException, AadharNumberNotFound
	{
		String token = "dummy";
		ProcessPensionInput processPensionInput = new ProcessPensionInput(420559429029l, 24400.0, 550);
		PensionerDetail pensionerDetail = new PensionerDetail(420559429029l, "Parthik", LocalDate.of(1999, 12, 03), "BSDPS1495K", 29000, 1200, "self", "SBI", "9029486523", "private");
		Mockito.when(pensionDisbursementFeignClient.getPensionerDetailByAadhaar(token, 420559429029l)).thenReturn(pensionerDetail);
		 ProcessPensionResponse processPensionResponse = pensionDisbursementServiceImpl.getResponce(token, processPensionInput);
	//	 Mockito.when(pensionDisbursementServiceImpl.getResponce(token, processPensionInput)).thenReturn(processPensionResponse);
		 assertEquals(processPensionResponse.getProcessPensionStatusCode(), 10);
		 
		 
//		 processPensionResponse.setProcessPensionStatusCode(10);
//		 if(authorisingClient.authorizeTheRequest(token))
//		 {
//			 assertEquals(pensionDisbursementController.getResponse(token, processPensionInput), processPensionResponse);
//		 }
//		 else
//		 {
//			assertThrows(AuthorizationException.class null)
//		 }
		 
	}
	
	@Test
	public void testResponce21() throws AuthorizationException, AadharNumberNotFound
	{
		String token = "dummy";
		ProcessPensionInput processPensionInput = new ProcessPensionInput(420559429029l, 24400.0, 500);
		PensionerDetail pensionerDetail = new PensionerDetail(420559429029l, "Parthik", LocalDate.of(1999, 12, 03), "BSDPS1495K", 29000, 1200, "self", "SBI", "9029486523", "private");
		Mockito.when(pensionDisbursementFeignClient.getPensionerDetailByAadhaar(token, 420559429029l)).thenReturn(pensionerDetail);
		 ProcessPensionResponse processPensionResponse = pensionDisbursementServiceImpl.getResponce(token, processPensionInput);
	//	 Mockito.when(pensionDisbursementServiceImpl.getResponce(token, processPensionInput)).thenReturn(processPensionResponse);
		 assertEquals(processPensionResponse.getProcessPensionStatusCode(), 21);
		 
		 
//		 processPensionResponse.setProcessPensionStatusCode(10);
//		 if(authorisingClient.authorizeTheRequest(token))
//		 {
//			 assertEquals(pensionDisbursementController.getResponse(token, processPensionInput), processPensionResponse);
//		 }
//		 else
//		 {
//			assertThrows(AuthorizationException.class null)
//		 }
		 
	}
	
	@Test
	public void testToken()
	{
		String token = "dummy";
		Mockito.when(authorisingClient.authorizeTheRequest(token)).thenReturn(true);
	}
}
