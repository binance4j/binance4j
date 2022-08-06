package com.binance4j.savings.dto;

import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A Flexible product.
 * 
 * @param asset                  Asset.
 * @param avgAnnualInterestRate  Avg annual interest rate.
 * @param tierAnnualInterestRate Tier annual interest rate.
 * @param canPurchase            Product can be purchase?
 * @param canRedeem              Product can be redeem?
 * @param featured               Featured.
 * @param minPurchaseAmount      Min purchase amount.
 * @param productId              Product id.
 * @param purchasedAmount        Purchased amount.
 * @param status                 Status.
 * @param upLimit                Up limit.
 * @param upLimitPerUser         Up limit per user.
 */
@ApiModel("")
public record FlexibleProduct(@ApiModelProperty("") String asset, @ApiModelProperty("") String avgAnnualInterestRate,
		@ApiModelProperty("") Map<String, String> tierAnnualInterestRate, @ApiModelProperty("") String latestAnnualInterestRate,
		@ApiModelProperty("") boolean canPurchase, @ApiModelProperty("") boolean canRedeem, @ApiModelProperty("") boolean featured,
		@ApiModelProperty("") String minPurchaseAmount, @ApiModelProperty("") String productId, @ApiModelProperty("") String purchasedAmount,
		@ApiModelProperty("") String status, @ApiModelProperty("") String upLimit, @ApiModelProperty("") String upLimitPerUser) {
}