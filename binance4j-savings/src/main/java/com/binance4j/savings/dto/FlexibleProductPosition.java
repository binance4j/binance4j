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
@ApiModel("")
public record FlexibleProductPosition(@ApiModelProperty("") Map<String, String> tierAnnualInterestRate, @ApiModelProperty("") String annualInterestRate,
		@ApiModelProperty("") String asset, @ApiModelProperty("") String avgAnnualInterestRate, @ApiModelProperty("") boolean canRedeem,
		@ApiModelProperty("") String dailyInterestRate, @ApiModelProperty("") String freeAmount, @ApiModelProperty("") String freezeAmount,
		@ApiModelProperty("") String lockedAmount, @ApiModelProperty("") String productId, @ApiModelProperty("") String productName,
		@ApiModelProperty("") String redeemingAmount, @ApiModelProperty("") String todayPurchasedAmount, @ApiModelProperty("") String totalAmount,
		@ApiModelProperty("") String totalInterest) {
}