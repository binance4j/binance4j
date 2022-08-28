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
@ApiModelProperty("Tier annual interest rate.")
Map<String, String> tierAnnualInterestRate,
@ApiModelProperty("Annual interest rate.") @JsonProperty("annualInterestRate : String? = null, @ApiModelProperty("Asset.") var asset ") var annualInterestRate:String?=null,
@ApiModelProperty("Asset.")
var asset:String?=null,
@ApiModelProperty("Avg annual interest rate.")
@JsonProperty("avgAnnualInterestRate ")
var avgAnnualInterestRate:String?=null,
@ApiModelProperty("Can redeem.")
@JsonProperty("canRedeem ")
var canRedeem:Boolean?=null,
@ApiModelProperty("Daily interest rate.")
@JsonProperty("dailyInterestRate ")
var dailyInterestRate:String?=null,
@ApiModelProperty("Free amount.")
@JsonProperty("freeAmount ")
var freeAmount:String?=null,
@ApiModelProperty("Freeze amount.")
@JsonProperty("freezeAmount ")
var freezeAmount:String?=null,
@ApiModelProperty("Locked amount.")
@JsonProperty("lockedAmount ")
var lockedAmount:String?=null,
@ApiModelProperty("Product id.") @JsonProperty("productId : String? = null, @ApiModelProperty("Product name.") var productName ")
var productId:String?=null,
@ApiModelProperty("Product name.")
var productName:String?=null,
@ApiModelProperty("Redeeming amount.")
@JsonProperty("redeemingAmount ")
var redeemingAmount:String?=null,
@ApiModelProperty("Today purchased amount.")
@JsonProperty("todayPurchasedAmount ")
var todayPurchasedAmount:String?=null,
@ApiModelProperty("Total amount.")
@JsonProperty("totalAmount ")
var totalAmount:String?=null,
@ApiModelProperty("Total interest.")
@JsonProperty("totalInterest ")
var totalInterest:String?=null)
{
}