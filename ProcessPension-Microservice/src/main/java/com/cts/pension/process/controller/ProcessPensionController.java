package com.cts.pension.process.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.pension.process.exception.AadharNumberNotFound;
import com.cts.pension.process.exception.AuthorizationException;
import com.cts.pension.process.exception.PensionerDetailException;
import com.cts.pension.process.feignclient.AuthorisingClient;
import com.cts.pension.process.model.PensionDetail;
import com.cts.pension.process.model.PensionerInput;
import com.cts.pension.process.model.ProcessPensionInput;
import com.cts.pension.process.model.ProcessPensionResponse;
import com.cts.pension.process.service.ProcessPensionServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
public class ProcessPensionController {

	@Autowired
	ProcessPensionServiceImpl processPensionServiceImpl;
	
	@Autowired
	private AuthorisingClient authorisingClient;
	
	@GetMapping("/PensionDetail")
	@ApiOperation(notes = "Returns the Pension Details", value = "Find the pension details")
	public PensionDetail getPensionDetail(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader,
			@RequestBody PensionerInput pensionerInput) throws AuthorizationException, PensionerDetailException, AadharNumberNotFound
	{
			if(authorisingClient.authorizeTheRequest(requestTokenHeader)) 
			{
				return processPensionServiceImpl.CalculatePension(requestTokenHeader,pensionerInput);
			}
			else
			{
				throw new AuthorizationException("Not allowed");
			}
	}

	
	@PostMapping("/ProcessPension")
	@ApiOperation(notes = "Returns the Process Responce Code(10 or 21)", value = "Find Process Responce Code, If Process code is 10 then Suceess and 21 means not success")
	public ProcessPensionResponse getprocessingCode(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader,
			@RequestBody ProcessPensionInput processPensionInput) throws AuthorizationException, AadharNumberNotFound
	{
		if(authorisingClient.authorizeTheRequest(requestTokenHeader)) 
		{
			return processPensionServiceImpl.getCode(requestTokenHeader,processPensionInput);
		}
		else
		{
			throw new AuthorizationException("Not allowed");
		}
		
		
	}
	

}