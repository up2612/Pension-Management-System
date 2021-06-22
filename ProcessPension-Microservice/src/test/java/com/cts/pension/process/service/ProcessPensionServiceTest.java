package com.cts.pension.process.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.pension.process.exception.AadharNumberNotFound;
import com.cts.pension.process.exception.AuthorizationException;
import com.cts.pension.process.exception.PensionerDetailException;
import com.cts.pension.process.feignclient.PensionDisbursementFeignClient;
import com.cts.pension.process.feignclient.PensionerDetailFeignClient;
import com.cts.pension.process.model.PensionDetail;
import com.cts.pension.process.model.PensionerDetail;
import com.cts.pension.process.model.PensionerInput;
import com.cts.pension.process.model.ProcessPensionInput;
import com.cts.pension.process.model.ProcessPensionResponse;

@SpringBootTest
public class ProcessPensionServiceTest {

	@InjectMocks
	private ProcessPensionServiceImpl processPensionServiceImpl;
	
	@Mock
	private PensionerDetailFeignClient pensionerDeatailFeignClient;
	
	@Mock
	private PensionDisbursementFeignClient pensionDisbursementFeignClient;
	
	
	@Test
	public void testCalculatePension() throws PensionerDetailException, AuthorizationException, AadharNumberNotFound
	{
		String token = "dummy";
		PensionerInput pensionerInput = new PensionerInput(420559429029l, "Parthik", LocalDate.of(1999, 12, 03), "BSDPS1495K", "self");
		PensionDetail pensionDetail =new PensionDetail("Parthik", LocalDate.of(1999, 12, 03), "BSDPS1495K", "self", 24400.0);
		PensionerDetail pensionerDetail = new PensionerDetail(420559429029l, "Parthik", LocalDate.of(1999, 12, 03), "BSDPS1495K", 29000, 1200, "self", "SBI", "9029486523", "private");
		Mockito.when(pensionerDeatailFeignClient.getPensionerDetailByAadhaar(token, 420559429029l)).thenReturn(pensionerDetail);
		System.out.println("hello"+processPensionServiceImpl.CalculatePension(token, pensionerInput));
		System.out.println("hello11"+pensionDetail);
		assertEquals(processPensionServiceImpl.CalculatePension(token, pensionerInput), pensionDetail); 
	}
	
	@Test
	public void testGetCodePrivate21() throws AuthorizationException, AadharNumberNotFound
	{
		String token = "dummy";
		ProcessPensionInput processPensionInput = new ProcessPensionInput(420559429029l, 24400.0, 500);
		ProcessPensionResponse processPensionResponse = new ProcessPensionResponse();
		processPensionResponse.setProcessPensionStatusCode(21);
		Mockito.when(pensionDisbursementFeignClient.getResponse(token, processPensionInput)).thenReturn(processPensionResponse);
		
		assertEquals(processPensionServiceImpl.getCode(token, processPensionInput), processPensionResponse); 
	}
	
	@Test
	public void testGetCodePrivate10() throws AuthorizationException, AadharNumberNotFound
	{
		String token = "dummy";
		ProcessPensionInput processPensionInput = new ProcessPensionInput(420559429029l, 24400.0, 550);
		ProcessPensionResponse processPensionResponse = new ProcessPensionResponse();
		processPensionResponse.setProcessPensionStatusCode(10);
		Mockito.when(pensionDisbursementFeignClient.getResponse(token, processPensionInput)).thenReturn(processPensionResponse);
		
		assertEquals(processPensionServiceImpl.getCode(token, processPensionInput), processPensionResponse); 
	}
	@Test
	public void testGetCodePublic21() throws AuthorizationException, AadharNumberNotFound
	{
		String token = "dummy";
		ProcessPensionInput processPensionInput = new ProcessPensionInput(342567345637l, 32002.0, 500);
		ProcessPensionResponse processPensionResponse = new ProcessPensionResponse();
		processPensionResponse.setProcessPensionStatusCode(21);
		Mockito.when(pensionDisbursementFeignClient.getResponse(token, processPensionInput)).thenReturn(processPensionResponse);
		
		assertEquals(processPensionServiceImpl.getCode(token, processPensionInput), processPensionResponse); 
	}
	
	@Test
	public void testGetCodePublic10() throws AuthorizationException, AadharNumberNotFound
	{
		String token = "dummy";
		ProcessPensionInput processPensionInput = new ProcessPensionInput(342567345637l, 32002.0, 550);
		ProcessPensionResponse processPensionResponse = new ProcessPensionResponse();
		processPensionResponse.setProcessPensionStatusCode(10);
		Mockito.when(pensionDisbursementFeignClient.getResponse(token, processPensionInput)).thenReturn(processPensionResponse);
		
		assertEquals(processPensionServiceImpl.getCode(token, processPensionInput), processPensionResponse); 
	}
}
