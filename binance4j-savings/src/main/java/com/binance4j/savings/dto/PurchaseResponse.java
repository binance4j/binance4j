package com.binance4j.savings.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Flexible purchase response.
 * 
 * @param purchaseId Purchase id.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record PurchaseResponse(
		/** Purchase id. */
		BigDecimal purchaseId) {
}