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
var symbol:String?=null,
@ApiModelProperty("Tier.")
var tier:int?=null,
@ApiModelProperty("Effective multiple.")
var effectiveMultiple:String?=null,
@ApiModelProperty("Initial risk ratio.")
var initialRiskRatio:String?=null,
@ApiModelProperty("Liquidation risk ratio.")
var liquidationRiskRatio:String?=null,
@ApiModelProperty("Base asset max borrowable.")
var baseAssetMaxBorrowable:String?=null,
@ApiModelProperty("Quote asset max borrowable.")
var quoteAssetMaxBorrowable:String?=null)
{
}