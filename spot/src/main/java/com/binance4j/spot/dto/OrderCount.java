package com.binance4j.spot.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The user's current order count usage for all intervals.
 * 
 * @property rateLimitType Type of order.
 * @property interval      Order interval.
 * @property intervalNum   Order interval num.
 * @property limit         Order limit.
 * @property count         Current order count.
 */
@ApiModel("The user's current order count usage for all intervals.")
data class OrderCount(
@ApiModelProperty("Type of order.")
var rateLimitType:String?=null,
@ApiModelProperty("Order interval.")
var interval:String?=null,
@ApiModelProperty("Order interval num.")
var intervalNum:int?=null,
@ApiModelProperty("Order limit.")
var limit:int?=null,
@ApiModelProperty("Current order count.") var count:int?=null)
{
}