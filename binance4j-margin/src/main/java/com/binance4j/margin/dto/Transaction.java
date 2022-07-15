package com.binance4j.margin.dto;

import com.binance4j.margin.client.MarginClient;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The {@link MarginClient#transfer}, {@link MarginClient#borrow} and {@link MarginClient#repay} response */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Transaction(
		/** The transaction id. */
		@JsonProperty("tranId") String transactionId) {
}