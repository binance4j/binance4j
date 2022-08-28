package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The tiers for the number of Base Coins Borrowings and Quote Coins Borrowings
 * currently exist in your account. Your
 * Isolated Margin account tier is determined by whichever is higher. Each tier
 * corresponds to a different Initial Risk
 * Rate and Liquidation Risk Ratio, and the Initial Risk Ratio determines your
 * highest available leverage multiple.
 * 
 * @param symbol                  Related symbol.
 * @param tier                    Tier.
 * @param effectiveMultiple       Effective multiple.
 * @param initialRiskRatio        Initial risk ratio.
 * @param liquidationRiskRatio    Liquidation risk ratio.
 * @param baseAssetMaxBorrowable  Base asset max borrowable.
 * @param quoteAssetMaxBorrowable Quote asset max borrowable.
 * @see <a href="https://www.binance.com/en/margin-data">Documentation</a>
 */
@ApiModel("The tiers for the number of Base Coins Borrowings and Quote Coins Borrowings currently exist in your account.")
public record IsolatedTierData(@ApiModelProperty("Related symbol.") String symbol, @ApiModelProperty("Tier.") int tier,
		@ApiModelProperty("Effective multiple.") String effectiveMultiple,
		@ApiModelProperty("Initial risk ratio.") String initialRiskRatio,
		@ApiModelProperty("Liquidation risk ratio.") String liquidationRiskRatio,
		@ApiModelProperty("Base asset max borrowable.") String baseAssetMaxBorrowable,
		@ApiModelProperty("Quote asset max borrowable.") String quoteAssetMaxBorrowable) {
}