package com.binance4j.wallet.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The snapshot assets balances.
 * 
 * @param asset         The asset abbreviation.
 * @param marginBalance The margin balance.
 * @param walletBalance The wallet balance.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record FuturesSnapshotDataAssets(
		/** The asset abbreviation. */
		String asset,
		/** The margin balance. */
		BigDecimal marginBalance,
		/** The wallet balance. */
		BigDecimal walletBalance) {
}