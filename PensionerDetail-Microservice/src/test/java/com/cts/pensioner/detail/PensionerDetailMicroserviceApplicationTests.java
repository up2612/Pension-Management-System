package com.cts.pensioner.detail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import com.cts.pensioner.detail.model.PensionerDetail;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

@SpringBootTest
class PensionerDetailMicroserviceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void main()
	{
		PensionerDetailMicroserviceApplication.main(new String[] {});
	}
//	@Test
//	void testPensionerDeatil() {
//		EqualsVerifier
//		.simple().forClass(PensionerDetail.class).verify();
//}
	
	
	@Test
	void testNoArgs()
	{
		assertThat(new PensionerDetail()).isNotNull();
	}
	
	
	@Test
	void testAllArgs()
	{
		PensionerDetail pensionerDetail = new PensionerDetail(420559429029l, "Parthik", LocalDate.of(1999, 12, 03), "BSDPS1495K", 29000, 1200, "self", "SBI", "9029486523", "private");
		assertThat(assertThat(pensionerDetail).isNotNull());
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
	void testEqualAndHashCode()
	{
		PensionerDetail pensionerDetail1 = new PensionerDetail(420559429029l, "Parthik", LocalDate.of(1999, 12, 03), "BSDPS1495K", 29000, 1200, "self", "SBI", "9029486523", "private");
		PensionerDetail pensionerDetail2 = new PensionerDetail(420559429029l, "Parthik", LocalDate.of(1999, 12, 03), "BSDPS1495K", 29000, 1200, "self", "SBI", "9029486523", "private");
		
			assertThat(assertThat(pensionerDetail1).isEqualTo(pensionerDetail2));
	
	}
	@Test
	void testNotEqualAndHashCode()
	{
		PensionerDetail pensionerDetail1 = new PensionerDetail(420559429030l, "Shubhm", LocalDate.of(1999, 12, 03), "BSDPS1495K", 29000, 1200, "self", "SBI", "9029486523", "private");
		PensionerDetail pensionerDetail2 = new PensionerDetail(420559429029l, "Parthik", LocalDate.of(1999, 12, 03), "BSDPS1495K", 29000, 1200, "self", "SBI", "9029486523", "private");
		
			assertThat(assertThat(pensionerDetail1).isNotEqualTo(pensionerDetail2));
	
	}
	
//	@Test
//	void testPensionerDeatil() {
//		EqualsVerifier.simple()
//		.forClass(PensionerDetail.class)
//		.suppress(Warning.SURROGATE_KEY)
//		.suppress(Warning.INHERITED_DIRECTLY_FROM_OBJECT)
//	
//		.verify();
//	}
	
	
}
