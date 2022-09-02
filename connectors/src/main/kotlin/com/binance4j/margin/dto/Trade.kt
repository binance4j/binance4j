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
 val id : Long,
@ApiModelProperty("Related order id.")
 val orderId : Long,
@ApiModelProperty("Traded symbol.")
 val symbol : String,
@ApiModelProperty("Commission asset .")
 val commissionAsset : String,
@ApiModelProperty("Commission amount.")
 val commission : String,
@ApiModelProperty("Trade price.")
 val price : String,
@ApiModelProperty("Traded quantity.")
 val qty : String,
@ApiModelProperty("Transaction time.")
 val time : Long,
@ApiModelProperty("Is it the best match?")
 val isBestMatch : Boolean,
@ApiModelProperty("Is it a buyer trade?")
 val isBuyer : Boolean,
@ApiModelProperty("Is it a maker trade?")
 val isMaker : Boolean,
@ApiModelProperty("Is it an isolated trade?")  val isIsolated : Boolean)
{
}