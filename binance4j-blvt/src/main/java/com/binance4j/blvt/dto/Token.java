package com.binance4j.blvt.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Binance leverage token.
 * 
 * @param tokenName          Token name.
 * @param description        Description.
 * @param underlying         Underlying.
 * @param tokenIssued        Token issued.
 * @param basket             Basket.
 * @param currentBaskets     Current baskets.
 * @param nav                Nav.
 * @param realLeverage       Real leverage.
 * @param fundingRate        Funding rate.
 * @param dailyManagementFee Daily management fee.
 * @param purchaseFeePct     Purchase Fee Pct.
 * @param dailyPurchaseLimit Daily Purchase Limit.
 * @param redeemFeePct       Redeem Fee Pct.
 * @param dailyRedeemLimit   Daily Redeem Limit.
 * @param timestamp          Timestamp.
 */
@ApiModel("Binance leverage token.")
public record Token(@ApiModelProperty("Token name.") String tokenName, @ApiModelProperty("Description.") String description,
		@ApiModelProperty("Underlying.") String underlying, @ApiModelProperty("Token issued.") String tokenIssued, @ApiModelProperty("Basket.") String basket,
		@ApiModelProperty("Current baskets.") List<Basket> currentBaskets, @ApiModelProperty("Nav.") String nav,
		@ApiModelProperty("Real leverage.") String realLeverage, @ApiModelProperty("Funding rate.") String fundingRate,
		@ApiModelProperty("Daily management fee.") String dailyManagementFee, @ApiModelProperty("Purchase Fee Pct.") String purchaseFeePct,
		@ApiModelProperty("Daily Purchase Limit.") String dailyPurchaseLimit, @ApiModelProperty("Redeem Fee Pct.") String redeemFeePct,
		@ApiModelProperty("Daily Redeem Limit.") String dailyRedeemLimit, @ApiModelProperty("Timestamp.") long timestamp) {
}
