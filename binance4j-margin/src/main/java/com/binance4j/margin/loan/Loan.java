package com.binance4j.margin.loan;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * Represents an executed trade history item.
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Loan {
	private LoanStatus status;
	private BigDecimal principal;
	private String isolatedSymbol;
	private String asset;
	private long timestamp;
	private long txId;
}