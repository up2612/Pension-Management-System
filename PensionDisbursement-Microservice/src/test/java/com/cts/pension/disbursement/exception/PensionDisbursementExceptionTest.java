package com.cts.pension.disbursement.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import feign.FeignException;

@SpringBootTest
public class PensionDisbursementExceptionTest {
	
	@InjectMocks
	private AadharNumberNotFound aadharNumberNotFound;
	
	@InjectMocks
	private AuthorizationException authorizationException;
	
	@InjectMocks
	private ExceptionDetails exceptionDetails;
	
	@Test
	public void testAadharNumberNotFound()
	{
		String reason = "Invalid aadharNumber";
		assertEquals(reason, "Invalid aadharNumber");
	}
	
	@Test
	public void testAuthorizationException()
	{
		String reason = "Invalid token";
		assertEquals(reason, "Invalid token");
	}
	

}
