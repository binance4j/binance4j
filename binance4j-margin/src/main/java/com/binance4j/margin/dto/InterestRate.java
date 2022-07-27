package com.binance4j.margin.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A loan interest rate
 * 
 * @param asset             The related coin.
 * @param dailyInterestRate The daily interest rate.
 * @param timestamp         The timestamp of the applied interest rate in ms.
 * @param vipLevel          The account VIP level.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record InterestRate(
		/** The related coin. */
		String asset,
		/** The daily interest rate. */
		String dailyInterestRate,
		/** The timestamp of the applied interest rate in ms. */
		long timestamp,
		/** The account VIP level. */
		int vipLevel) {
}