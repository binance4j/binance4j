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
 * @property symbol                  Related symbol.
 * @property tier                    Tier.
 * @property effectiveMultiple       Effective multiple.
 * @property initialRiskRatio        Initial risk ratio.
 * @property liquidationRiskRatio    Liquidation risk ratio.
 * @property baseAssetMaxBorrowable  Base asset max borrowable.
 * @property quoteAssetMaxBorrowable Quote asset max borrowable.
 * @see <a href="https://www.binance.com/en/margin-data">Documentation</a>
 */
@ApiModel("The tiers for the number of Base Coins Borrowings and Quote Coins Borrowings currently exist in your account.")
data class IsolatedTierData(
@ApiModelProperty("Related symbol.")
 val symbol : String,
@ApiModelProperty("Tier.")
 var tier:Int,
@ApiModelProperty("Effective multiple.")
 val effectiveMultiple : String,
@ApiModelProperty("Initial risk ratio.")
 val initialRiskRatio : String,
@ApiModelProperty("Liquidation risk ratio.")
 val liquidationRiskRatio : String,
@ApiModelProperty("Base asset max borrowable.")
 val baseAssetMaxBorrowable : String,
@ApiModelProperty("Quote asset max borrowable.")
 val quoteAssetMaxBorrowable : String)
{
}