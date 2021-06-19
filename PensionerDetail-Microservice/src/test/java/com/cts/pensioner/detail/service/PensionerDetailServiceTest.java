package com.cts.pensioner.detail.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.pensioner.detail.exception.AadharNumberNotFound;
import com.cts.pensioner.detail.feignclient.AuthorisingClient;
import com.cts.pensioner.detail.model.PensionerDetail;
import com.cts.pensioner.detail.repository.PensionerDetailRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PensionerDetailServiceTest {

	@InjectMocks
	private PensionerDetailServiceImpl pensionerDetailServiceImpl;
	
	@Mock
	private PensionerDetailRepository pensionerDetailRepository;
	
	@Mock
	private AuthorisingClient authClient;
	
	@Test
	public void testGetPensionDetailByAadharCard() throws AadharNumberNotFound
	{
		PensionerDetail pensionerDetail = new PensionerDetail(420559429029l, "Parthik", LocalDate.of(1999, 12, 03), "BSDPS1495K", 29000, 1200, "self", "SBI", "9029486523", "private");
		
		String token = "dummy";
//		Mockito.when(authClient.authorizeTheRequest(token)).thenReturn(true);
		Mockito.when(pensionerDetailRepository.findById(420559429029l)).thenReturn(Optional.of(pensionerDetail));
		assertEquals(pensionerDetailServiceImpl.getPensionerDetailByAadharCard(token,420559429029l),pensionerDetail);
	}
	
}
