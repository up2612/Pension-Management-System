package com.cts.pensioner.detail.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


@Data
@Entity
@Table(name = "pensioner")
public class PensionerDetail {
	
	@Id
	@Column(name = "aadhar")
	private long aadharNumber;
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dob")
	private LocalDate dateOfBirth;
	private String pan;
	@Column(name = "salary")
	private double salaryEarned;
	private double allowances;
	@Column(name =  "pension")
	private String pensionType;
	@Column(name = "bank")
	private String bankName;
	@Column(name = "accnumber")
	private String accountNumber;
	@Column(name = "banktype")
	private String bankType;
	
}
