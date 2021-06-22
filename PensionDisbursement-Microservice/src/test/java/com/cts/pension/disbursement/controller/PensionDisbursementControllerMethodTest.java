package com.cts.pension.disbursement.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cts.pension.disbursement.exception.AadharNumberNotFound;
import com.cts.pension.disbursement.exception.AuthorizationException;
import com.cts.pension.disbursement.feignclient.AuthorisingClient;
import com.cts.pension.disbursement.feignclient.PensionDisbursementFeignClient;
import com.cts.pension.disbursement.model.ProcessPensionInput;
import com.cts.pension.disbursement.model.ProcessPensionResponse;
import com.cts.pension.disbursement.service.PensionDisbursementServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class PensionDisbursementControllerMethodTest {

	@InjectMocks
	private PensionDisbursementController pensionDisbursementController;

	
	@MockBean
	private AuthorisingClient authorisingClient;
	
	@MockBean
	PensionDisbursementFeignClient pensionDisbursementFeignClient;
	
	@Mock
	private ProcessPensionResponse responce;
	
	@Mock
	private PensionDisbursementServiceImpl pensionDisbursementServiceImpl;
	
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
	public void testControllerForPrivate1() throws AuthorizationException, AadharNumberNotFound
	{
		String token = "dummy";
		Mockito.when(authorisingClient.authorizeTheRequest(token)).thenReturn(true);
		
		ProcessPensionInput processPensionInput = new ProcessPensionInput(420559429029l, 24400.0, 550);
		ProcessPensionResponse processPensionResponse = new ProcessPensionResponse();
		processPensionResponse.setProcessPensionStatusCode(10);
		
		Mockito.when(pensionDisbursementServiceImpl.getResponce(token, processPensionInput)).thenReturn(processPensionResponse);
		assertEquals(pensionDisbursementController.getResponse(token, processPensionInput), processPensionResponse);
	
	}
	@Test
	public void testControllerForPrivate2() throws AuthorizationException, AadharNumberNotFound
	{
		String token = "dummy";
		Mockito.when(authorisingClient.authorizeTheRequest(token)).thenReturn(true);
		
		ProcessPensionInput processPensionInput = new ProcessPensionInput(420559429029l, 24400.0, 500);
		ProcessPensionResponse processPensionResponse = new ProcessPensionResponse();
		processPensionResponse.setProcessPensionStatusCode(21);
		
		Mockito.when(pensionDisbursementServiceImpl.getResponce(token, processPensionInput)).thenReturn(processPensionResponse);
		assertEquals(pensionDisbursementController.getResponse(token, processPensionInput), processPensionResponse);
	
	}
	
	@Test
	public void testControllerForPublic1() throws AuthorizationException, AadharNumberNotFound
	{
		String token = "dummy";
		Mockito.when(authorisingClient.authorizeTheRequest(token)).thenReturn(true);
		
		ProcessPensionInput processPensionInput = new ProcessPensionInput(110005635647l, 24400.0, 500);
		ProcessPensionResponse processPensionResponse = new ProcessPensionResponse();
		processPensionResponse.setProcessPensionStatusCode(10);
		
		Mockito.when(pensionDisbursementServiceImpl.getResponce(token, processPensionInput)).thenReturn(processPensionResponse);
		assertEquals(pensionDisbursementController.getResponse(token, processPensionInput), processPensionResponse);
	
	}
	@Test
	public void testControllerForPublic2() throws AuthorizationException, AadharNumberNotFound
	{
		String token = "dummy";
		Mockito.when(authorisingClient.authorizeTheRequest(token)).thenReturn(true);
		
		ProcessPensionInput processPensionInput = new ProcessPensionInput(110005635647l, 24400.0, 550);
		ProcessPensionResponse processPensionResponse = new ProcessPensionResponse();
		processPensionResponse.setProcessPensionStatusCode(21);
		
		Mockito.when(pensionDisbursementServiceImpl.getResponce(token, processPensionInput)).thenReturn(processPensionResponse);
		assertEquals(pensionDisbursementController.getResponse(token, processPensionInput), processPensionResponse);
	
	}
}
