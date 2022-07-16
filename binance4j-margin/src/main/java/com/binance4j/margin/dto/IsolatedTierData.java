package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The tiers for the number of Base Coins Borrowings and Quote Coins Borrowings currently exist in your account. Your
 * Isolated Margin account tier is determined by whichever is higher. Each tier corresponds to a different Initial Risk
 * Rate and Liquidation Risk Ratio, and the Initial Risk Ratio determines your highest available leverage multiple.
 * 
 * @param symbol                  The related symbol.
 * @param tier                    The tier.
 * @param effectiveMultiple       The effective multiple.
 * @param initialRiskRatio        The initial risk ratio.
 * @param liquidationRiskRatio    The liquidation risk ratio.
 * @param baseAssetMaxBorrowable  The base asset max borrowable.
 * @param quoteAssetMaxBorrowable The quote asset max borrowable.
 * 
 * @see <a href="https://www.binance.com/en/margin-data">Documentation</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record IsolatedTierData(
		/** The related symbol. */
		String symbol,
		/** The tier. */
		int tier,
		/** The effective multiple. */
		BigDecimal effectiveMultiple,
		/** The initial risk ratio. */
		BigDecimal initialRiskRatio,
		/** The liquidation risk ratio. */
		BigDecimal liquidationRiskRatio,
		/** The base asset max borrowable. */
		BigDecimal baseAssetMaxBorrowable,
		/** The quote asset max borrowable. */
		BigDecimal quoteAssetMaxBorrowable) {
}