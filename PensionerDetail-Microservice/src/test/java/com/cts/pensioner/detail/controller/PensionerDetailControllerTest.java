package com.cts.pensioner.detail.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.pensioner.detail.exception.AadharNumberNotFound;
import com.cts.pensioner.detail.exception.AuthorizationException;
import com.cts.pensioner.detail.feignclient.AuthorisingClient;
import com.cts.pensioner.detail.model.PensionerDetail;
import com.cts.pensioner.detail.repository.PensionerDetailRepository;
import com.cts.pensioner.detail.service.PensionerDetailServiceImpl;

@SpringBootTest
public class PensionerDetailControllerTest {

	@Mock
	private AuthorisingClient authorisingClient;
	
	@InjectMocks
	private PensionerDetailController pensionerDetailController;
	
	@InjectMocks
	private PensionerDetailServiceImpl pensionerDetailServiceImpl;
	
	@Mock
	private PensionerDetailRepository pensionerDetailRepository;
	@Test
	public void testToken()
	{
		String token = "dummy";
		Mockito.when(authorisingClient.authorizeTheRequest(token)).thenReturn(true);
	}
	
//	@Test
//	public void testGetPensionerDetailByAadhar() throws AuthorizationException, AadharNumberNotFound
//	{
//		String token = "dummy";
//		PensionerDetail pensionerDetail = new PensionerDetail(420559429029l, "Parthik", LocalDate.of(1999, 12, 03), "BSDPS1495K", 29000, 1200, "self", "SBI", "9029486523", "private");
//		
//		Mockito.when(authorisingClient.authorizeTheRequest(token)).thenReturn(true);
//		Mockito.when(pensionerDetailServiceImpl.getPensionerDetailByAadharCard(token, 420559429029l)).thenReturn(pensionerDetail);
//		Mockito.when(pensionerDetailRepository.findById(420559429029l)).thenReturn(Optional.of(pensionerDetail));
//		
//		assertNotNull(pensionerDetailServiceImpl.getPensionerDetailByAadharCard(token, 420559429029l));
//		assertEquals(pensionerDetailServiceImpl.getPensionerDetailByAadharCard(token,420559429029l),pensionerDetail);
//		//Mockito.when(pensionerDetailController.getPensionerDetailByAadhar(token, 420559429029l)).thenReturn(pensionerDetail);
//		assertEquals(pensionerDetailController.getPensionerDetailByAadhar(token, 420559429029l), pensionerDetail);
//	}
}
