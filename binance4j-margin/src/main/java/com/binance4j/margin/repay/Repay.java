package com.binance4j.margin.repay;

import java.math.BigDecimal;

import com.binance4j.margin.loan.LoanStatus;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Repay {
	private String isolatedSymbol;
	private String amount;
	private String asset;
	private BigDecimal interest;
	private BigDecimal principal;
	private LoanStatus status;
	private long timestamp;
	private long txId;
}