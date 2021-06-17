package com.cts.pension.disbursement.service;

import com.cts.pension.disbursement.exception.AadharNumberNotFound;
import com.cts.pension.disbursement.exception.AuthorizationException;
import com.cts.pension.disbursement.model.ProcessPensionInput;
import com.cts.pension.disbursement.model.ProcessPensionResponse;

public interface PensionDisbursementService {
	public ProcessPensionResponse getResponce(String token,ProcessPensionInput processPensionInput) throws AuthorizationException, AadharNumberNotFound;
	

}
