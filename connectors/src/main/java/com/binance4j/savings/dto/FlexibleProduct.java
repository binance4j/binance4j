package com.binance4j.savings.dto;

import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A Flexible product.
 * 
 * @property asset                    Asset.
 * @property avgAnnualInterestRate    Avg annual interest rate.
 * @property tierAnnualInterestRate   Tier annual interest rate.
 * @property latestAnnualInterestRate Latest annual intarest rate.
 * @property canPurchase              Product can be purchase?
 * @property canRedeem                Product can be redeem?
 * @property featured                 Featured.
 * @property minPurchaseAmount        Min purchase amount.
 * @property productId                Product id.
 * @property purchasedAmount          Purchased amount.
 * @property status                   Status.
 * @property upLimit                  Up limit.
 * @property upLimitPerUser           Up limit per user.
 */
@ApiModel("A Flexible product.")
data class FlexibleProduct(
@ApiModelProperty("Asset.")
@JsonProperty("asset") var asset: String = "",
@ApiModelProperty("Avg annual interest rate.")
@JsonProperty("avgAnnualInterestRate") var avgAnnualInterestRate: String = "",
@ApiModelProperty("Tier annual interest rate.") Map<String, String> tierAnnualInterestRate,
@ApiModelProperty("Latest annual intarest rate.")
@JsonProperty("latestAnnualInterestRate") var latestAnnualInterestRate: String = "",
@ApiModelProperty("Product can be purchase?")
@JsonProperty("canPurchase") var canPurchase: Boolean = false,
@ApiModelProperty("Product can be redeem?")
@JsonProperty("canRedeem") var canRedeem: Boolean = false,
@ApiModelProperty("Featured.")
@JsonProperty("featured") var featured: Boolean = false,
@ApiModelProperty("Min purchase amount.")
@JsonProperty("minPurchaseAmount") var minPurchaseAmount: String = "",
@ApiModelProperty("Product id.")
@JsonProperty("productId") var productId: String = "",
@ApiModelProperty("Purchased amount.")
@JsonProperty("purchasedAmount") var purchasedAmount: String = "",
@ApiModelProperty("Status.")
@JsonProperty("status") var status: String = "",
@ApiModelProperty("Up limit.")
@JsonProperty("upLimit") var upLimit: String = "",
@ApiModelProperty("Up limit per user.")
@JsonProperty("upLimitPerUser") var upLimitPerUser: String = "")
{
}