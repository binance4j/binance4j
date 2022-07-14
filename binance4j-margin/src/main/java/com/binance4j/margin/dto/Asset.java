package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Asset(
		String assetFullName,
		String assetName,
		Boolean isBorrowable,
		Boolean isMortgageable,
		BigDecimal userMinBorrow,
		BigDecimal userMinRepay) {
}
