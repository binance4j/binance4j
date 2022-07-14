package com.binance4j.margin.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record IsolatedMarginFee(
		int vipLevel,
		String symbol,
		BigDecimal leverage,
		List<IsolatedMarginFeeData> data) {
}