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
@JsonProperty("asset") var asset:String?=null,
@ApiModelProperty("Avg annual interest rate.")
@JsonProperty("avgAnnualInterestRate") var avgAnnualInterestRate:String?=null,
@ApiModelProperty("Tier annual interest rate.") Map<String, String> tierAnnualInterestRate,
@ApiModelProperty("Latest annual intarest rate.")
@JsonProperty("latestAnnualInterestRate") var latestAnnualInterestRate:String?=null,
@ApiModelProperty("Product can be purchase?")
@JsonProperty("canPurchase") var canPurchase:Boolean?=null,
@ApiModelProperty("Product can be redeem?")
@JsonProperty("canRedeem") var canRedeem:Boolean?=null,
@ApiModelProperty("Featured.")
@JsonProperty("featured") var featured:Boolean?=null,
@ApiModelProperty("Min purchase amount.")
@JsonProperty("minPurchaseAmount") var minPurchaseAmount:String?=null,
@ApiModelProperty("Product id.")
@JsonProperty("productId") var productId:String?=null,
@ApiModelProperty("Purchased amount.")
@JsonProperty("purchasedAmount") var purchasedAmount:String?=null,
@ApiModelProperty("Status.")
@JsonProperty("status") var status:String?=null,
@ApiModelProperty("Up limit.")
@JsonProperty("upLimit") var upLimit:String?=null,
@ApiModelProperty("Up limit per user.")
@JsonProperty("upLimitPerUser") var upLimitPerUser:String?=null)
{
}