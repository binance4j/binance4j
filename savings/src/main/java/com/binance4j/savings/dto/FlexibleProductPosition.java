package com.binance4j.savings.dto;

import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Flexible product position.
 * 
 * @property tierAnnualInterestRate Tier annual interest rate.
 * @property annualInterestRate     Annual interest rate.
 * @property asset                  Asset.
 * @property avgAnnualInterestRate  Avg annual interest rate.
 * @property canRedeem              Can redeem.
 * @property dailyInterestRate      Daily interest rate.
 * @property freeAmount             Free amount.
 * @property freezeAmount           Freeze amount.
 * @property lockedAmount           Locked amount.
 * @property productId              Product id.
 * @property productName            Product name.
 * @property redeemingAmount        Redeeming amount.
 * @property todayPurchasedAmount   Today purchased amount.
 * @property totalAmount            Total amount.
 * @property totalInterest          Total interest.
 */
@ApiModel("Flexible product position.")
data class FlexibleProductPosition(
		@ApiModelProperty("Tier annual interest rate.") Map<String, String> tierAnnualInterestRate,
		@ApiModelProperty("Annual interest rate.") var annualInterestRate : String? = null, @ApiModelProperty("Asset.") var asset : String? = null,
		@ApiModelProperty("Avg annual interest rate.") var avgAnnualInterestRate : String? = null,
		@ApiModelProperty("Can redeem.") var canRedeem : Boolean? = null,
		@ApiModelProperty("Daily interest rate.") var dailyInterestRate : String? = null,
		@ApiModelProperty("Free amount.") var freeAmount : String? = null,
		@ApiModelProperty("Freeze amount.") var freezeAmount : String? = null,
		@ApiModelProperty("Locked amount.") var lockedAmount : String? = null,
		@ApiModelProperty("Product id.") var productId : String? = null, @ApiModelProperty("Product name.") var productName : String? = null,
		@ApiModelProperty("Redeeming amount.") var redeemingAmount : String? = null,
		@ApiModelProperty("Today purchased amount.") var todayPurchasedAmount : String? = null,
		@ApiModelProperty("Total amount.") var totalAmount : String? = null,
		@ApiModelProperty("Total interest.") var totalInterest : String? = null) {
}