package com.cts.portal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProcessPensionInput {

	private long aadharNumber;
	private double pensionAmount;
	private double bankCharge;
	
	
}
