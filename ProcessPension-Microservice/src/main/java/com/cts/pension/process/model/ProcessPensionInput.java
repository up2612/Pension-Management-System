package com.cts.pension.process.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProcessPensionInput {

	private long aadharNumber;
	private double pesionAmount;
	private double bankCharge;
	
	
}
