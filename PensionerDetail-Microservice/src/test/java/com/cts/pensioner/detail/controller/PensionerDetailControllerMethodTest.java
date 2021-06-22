package com.cts.pensioner.detail.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cts.pensioner.detail.exception.AadharNumberNotFound;
import com.cts.pensioner.detail.exception.AuthorizationException;
import com.cts.pensioner.detail.feignclient.AuthorisingClient;
import com.cts.pensioner.detail.model.PensionerDetail;
import com.cts.pensioner.detail.service.PensionerDetailServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PensionerDetailControllerMethodTest {

	@InjectMocks
	private PensionerDetailController pensionerDetailController;
	
	@MockBean
	private AuthorisingClient authorisingClient;
	
	@Mock
	private PensionerDetailServiceImpl pensionerDetailServiceImpl;
	
	@Test
	public void testToken()
	{
		String token = "dummy";
		Mockito.when(authorisingClient.authorizeTheRequest(token)).thenReturn(true);
	}
	
	@Test
	public void testGetPensionerDetailByAadhar() throws AadharNumberNotFound, AuthorizationException
	{
		String token = "dummy";
		Mockito.when(authorisingClient.authorizeTheRequest(token)).thenReturn(true);
		PensionerDetail pensionerDetail = new PensionerDetail(420559429029l, "Parthik", LocalDate.of(1999, 12, 03), "BSDPS1495K", 29000, 1200, "self", "SBI", "9029486523", "private");
		Mockito.when(pensionerDetailServiceImpl.getPensionerDetailByAadharCard(token, 420559429029l)).thenReturn(pensionerDetail);
		assertEquals(pensionerDetailController.getPensionerDetailByAadhar(token, 420559429029l), pensionerDetail);
	}
	
	@Test
	public void testGetAllPensioner() throws AuthorizationException
	{
		String token = "dummy";
		Mockito.when(authorisingClient.authorizeTheRequest(token)).thenReturn(true);
		List<PensionerDetail> pensionerDetails = new ArrayList<PensionerDetail>();
		
		assertEquals(pensionerDetailController.getAllPensioner(token), pensionerDetails);
		
	}
	
}
