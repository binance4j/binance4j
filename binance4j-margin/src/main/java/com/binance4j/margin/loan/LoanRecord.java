package com.binance4j.margin.loan;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * History of account withdrawals.
 *
 * 
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoanRecord {
	@JsonProperty("totalclas")
	private int total;
	@JsonProperty("rowsclas")
	private List<Loan> rows;
}