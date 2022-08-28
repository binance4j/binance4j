package com.binance4j.savings.dto;

import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A Flexible product.
 * 
 * @param asset                    Asset.
 * @param avgAnnualInterestRate    Avg annual interest rate.
 * @param tierAnnualInterestRate   Tier annual interest rate.
 * @param latestAnnualInterestRate Latest annual intarest rate.
 * @param canPurchase              Product can be purchase?
 * @param canRedeem                Product can be redeem?
 * @param featured                 Featured.
 * @param minPurchaseAmount        Min purchase amount.
 * @param productId                Product id.
 * @param purchasedAmount          Purchased amount.
 * @param status                   Status.
 * @param upLimit                  Up limit.
 * @param upLimitPerUser           Up limit per user.
 */
@ApiModel("A Flexible product.")
public record FlexibleProduct(@ApiModelProperty("Asset.") String asset,
		@ApiModelProperty("Avg annual interest rate.") String avgAnnualInterestRate,
		@ApiModelProperty("Tier annual interest rate.") Map<String, String> tierAnnualInterestRate,
		@ApiModelProperty("Latest annual intarest rate.") String latestAnnualInterestRate,
		@ApiModelProperty("Product can be purchase?") boolean canPurchase,
		@ApiModelProperty("Product can be redeem?") boolean canRedeem, @ApiModelProperty("Featured.") boolean featured,
		@ApiModelProperty("Min purchase amount.") String minPurchaseAmount,
		@ApiModelProperty("Product id.") String productId,
		@ApiModelProperty("Purchased amount.") String purchasedAmount, @ApiModelProperty("Status.") String status,
		@ApiModelProperty("Up limit.") String upLimit, @ApiModelProperty("Up limit per user.") String upLimitPerUser) {
}