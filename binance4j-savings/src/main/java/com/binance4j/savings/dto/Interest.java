package com.binance4j.savings.dto;

/**
 * Lending interest.
 * 
 * @param asset       Asset.
 * @param interest    Interest.
 * @param lendingType LendingType.
 * @param productName ProductName.
 * @param time        Time in ms.
 */
public record Interest(
		/** Asset. */
		String asset,
		/** Interest. */
		String interest,
		/** LendingType. */
		String lendingType,
		/** ProductName. */
		String productName,
		/** Time in ms. */
		long time) {
}