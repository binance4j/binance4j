package com.binance4j.margin.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CrossMarginFee(
		int vipLevel,
		String coin,
		boolean transferIn,
		boolean borrowable,
		BigDecimal dailyInterest,
		BigDecimal yearlyInterest,
		BigDecimal borrowLimit,
		List<String> marginablePairs) {
}