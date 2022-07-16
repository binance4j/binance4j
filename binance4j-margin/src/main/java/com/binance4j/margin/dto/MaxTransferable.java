package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Max transferable amount
 * 
 * @param amount The max transferable amount
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MaxTransferable(
		/** The max transferable amount. */
		BigDecimal amount) {
}