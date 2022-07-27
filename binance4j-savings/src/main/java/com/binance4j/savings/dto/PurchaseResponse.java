package com.binance4j.savings.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Flexible purchase response.
 * 
 * @param purchaseId Purchase id.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record PurchaseResponse(
		/** Purchase id. */
		String purchaseId) {
}