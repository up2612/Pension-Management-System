package com.cts.pension.disbursement;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.pension.disbursement.model.PensionerDetail;
import com.cts.pension.disbursement.model.ProcessPensionInput;
import com.cts.pension.disbursement.model.ProcessPensionResponse;

import nl.jqno.equalsverifier.EqualsVerifier;

@SpringBootTest
class PensionDisbursementMicroserviceApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void main()
	{
		PensionDisbursementMicroserviceApplication.main(new String[] {});
	}
	
	@Test
	void testPensionerDeatil() {
		EqualsVerifier.simple().forClass(PensionerDetail.class).verify();
	}
	
	@Test
	void testProcessPensionerInput() {
		EqualsVerifier.simple().forClass(ProcessPensionInput.class).verify();
	}
	@Test
	void testProcessPensionResponseDeatils() {
		EqualsVerifier.simple().forClass(ProcessPensionResponse.class).verify();
	}
	
	@Test
	void testSetterMethod()
	{
		PensionerDetail pensionerDetail = new PensionerDetail();
		pensionerDetail.setAadharNumber(420559429029l);
		pensionerDetail.setName("Parthik");
		pensionerDetail.setDateOfBirth(LocalDate.of(1999, 12, 03));
		pensionerDetail.setPan("BSDPS1495K");
		pensionerDetail.setSalaryEarned(29000);
		pensionerDetail.setAllowances(1200);
		pensionerDetail.setPensionType("self");
		pensionerDetail.setBankName("SBI");
		pensionerDetail.setAccountNumber("9029486523");
		pensionerDetail.setBankType("private");
		
		assertThat(assertThat(pensionerDetail).isNotNull());
	}
	
	@Test
	void testNoArgs()
	{
		assertThat(new PensionerDetail()).isNotNull();
	}
	
	@Test
	void testEqualAndHashCode()
	{
		PensionerDetail pensionerDetail1 = new PensionerDetail(420559429029l, "Parthik", LocalDate.of(1999, 12, 03), "BSDPS1495K", 29000, 1200, "self", "SBI", "9029486523", "private");
		PensionerDetail pensionerDetail2 = new PensionerDetail(420559429029l, "Parthik", LocalDate.of(1999, 12, 03), "BSDPS1495K", 29000, 1200, "self", "SBI", "9029486523", "private");
		
			assertThat(assertThat(pensionerDetail1).isEqualTo(pensionerDetail2));
	
	}
	
	@Test
	void testProcessPensionResponce()
	{
		ProcessPensionResponse processPensionResponse = new ProcessPensionResponse();
		processPensionResponse.setProcessPensionStatusCode(10);
		assertThat(assertThat(processPensionResponse).isNotNull());
	}
}
