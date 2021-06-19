package com.cts.pension.process.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.pension.process.exception.AadharNumberNotFound;
import com.cts.pension.process.exception.AuthorizationException;
import com.cts.pension.process.exception.PensionerDetailException;
import com.cts.pension.process.feignclient.PensionDisbursementFeignClient;
import com.cts.pension.process.feignclient.PensionerDetailFeignClient;
import com.cts.pension.process.model.PensionerDetail;
import com.cts.pension.process.model.PensionerInput;

@SpringBootTest
public class ProcessPensionServiceTest {

	@InjectMocks
	private ProcessPensionServiceImpl processPensionServiceImpl;
	
	@Mock
	private PensionerDetailFeignClient pensionerDeatailFeignClient;
	
	@Mock
	private PensionDisbursementFeignClient pensionDisbursementFeignClient;
	
	
	
}
