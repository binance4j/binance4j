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
var asset:String?=null,
@ApiModelProperty("Avg annual interest rate.")
var avgAnnualInterestRate:String?=null,
@ApiModelProperty("Tier annual interest rate.") Map<String, String> tierAnnualInterestRate,
@ApiModelProperty("Latest annual intarest rate.")
var latestAnnualInterestRate:String?=null,
@ApiModelProperty("Product can be purchase?")
var canPurchase:Boolean?=null,
@ApiModelProperty("Product can be redeem?")
var canRedeem:Boolean?=null,
@ApiModelProperty("Featured.")
var featured:Boolean?=null,
@ApiModelProperty("Min purchase amount.")
var minPurchaseAmount:String?=null,
@ApiModelProperty("Product id.")
var productId:String?=null,
@ApiModelProperty("Purchased amount.")
var purchasedAmount:String?=null,
@ApiModelProperty("Status.")
var status:String?=null,
@ApiModelProperty("Up limit.")
var upLimit:String?=null,
@ApiModelProperty("Up limit per user.")
var upLimitPerUser:String?=null)
{
}