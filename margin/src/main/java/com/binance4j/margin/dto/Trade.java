package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A trade being part of a {@link NewOrderRecord}.
 * 
 * @property id              Trade id.
 * @property orderId         Related order id.
 * @property symbol          Traded symbol.
 * @property commissionAsset Commission asset .
 * @property commission      Commission amount.
 * @property price           Trade price.
 * @property qty             Traded quantity.
 * @property time            Transaction time.
 * @property isBestMatch     Is it the best match?
 * @property isBuyer         Is it a buyer trade?
 * @property isMaker         Is it a maker trade?
 * @property isIsolated      Is it an isolated trade?
 */
@ApiModel("A trade being part of a NewOrderRecord.")
data class Trade(
@ApiModelProperty("Trade id.")
var id:Long?=null,
@ApiModelProperty("Related order id.")
var orderId:Long?=null,
@ApiModelProperty("Traded symbol.")
var symbol:String?=null,
@ApiModelProperty("Commission asset .")
var commissionAsset:String?=null,
@ApiModelProperty("Commission amount.")
var commission:String?=null,
@ApiModelProperty("Trade price.")
var price:String?=null,
@ApiModelProperty("Traded quantity.")
var qty:String?=null,
@ApiModelProperty("Transaction time.")
var time:Long?=null,
@ApiModelProperty("Is it the best match?")
var isBestMatch:Boolean?=null,
@ApiModelProperty("Is it a buyer trade?")
var isBuyer:Boolean?=null,
@ApiModelProperty("Is it a maker trade?")
var isMaker:Boolean?=null,
@ApiModelProperty("Is it an isolated trade?") var isIsolated:Boolean?=null)
{
}