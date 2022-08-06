package com.binance4j.savings.dto;

import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Flexible product position.
 * 
 * @param tierAnnualInterestRate Tier annual interest rate.
 * @param annualInterestRate     Annual interest rate.
 * @param asset                  Asset.
 * @param avgAnnualInterestRate  Avg annual interest rate.
 * @param canRedeem              Can redeem.
 * @param dailyInterestRate      Daily interest rate.
 * @param freeAmount             Free amount.
 * @param freezeAmount           Freeze amount.
 * @param lockedAmount           Locked amount.
 * @param productId              Product id.
 * @param productName            Product name.
 * @param redeemingAmount        Redeeming amount.
 * @param todayPurchasedAmount   Today purchased amount.
 * @param totalAmount            Total amount.
 * @param totalInterest          Total interest.
 */
@ApiModel("Flexible product position.")
public record FlexibleProductPosition(@ApiModelProperty("Tier annual interest rate.") Map<String, String> tierAnnualInterestRate,
		@ApiModelProperty("Annual interest rate.") String annualInterestRate, @ApiModelProperty("Asset.") String asset,
		@ApiModelProperty("Avg annual interest rate.") String avgAnnualInterestRate, @ApiModelProperty("Can redeem.") boolean canRedeem,
		@ApiModelProperty("Daily interest rate.") String dailyInterestRate, @ApiModelProperty("Free amount.") String freeAmount,
		@ApiModelProperty("Freeze amount.") String freezeAmount, @ApiModelProperty("Locked amount.") String lockedAmount,
		@ApiModelProperty("Product id.") String productId, @ApiModelProperty("Product name.") String productName,
		@ApiModelProperty("Redeeming amount.") String redeemingAmount, @ApiModelProperty("Today purchased amount.") String todayPurchasedAmount,
		@ApiModelProperty("Total amount.") String totalAmount, @ApiModelProperty("Total interest.") String totalInterest) {
}