package com.cts.pension.disbursement.model;

import lombok.Data;

@Data
public class ProcessPensionInput {
	private Long aadharNumber;
	private double pensionAmount;
	private double bankCharge;
}