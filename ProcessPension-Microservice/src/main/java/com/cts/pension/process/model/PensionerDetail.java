package com.cts.pension.process.model;

import java.time.LocalDate;



import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


@Data
public class PensionerDetail {
	
	private long aadharNumber;
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;
	private String pan;
	private double salaryEarned;
	private double allowances;
	private String pensionType;
	private String bankName;
	private String accountNumber;
	private String bankType;
	
}
