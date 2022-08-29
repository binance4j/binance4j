package com.binance4j.margin.dto;

import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.TimeInForce;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Market order to exit leveraged position.
 * 
 * @property orderId     Order id.
 * @property updatedTime Liquidation timestamp in ms.
 * @property avgPrice    Symbol average price.
 * @property executedQty Executed quantity.
 * @property timeInForce Order time in force.
 * @property side        Order side.
 * @property symbol      Order symbol.
 * @property price       Order price.
 * @property qty         Order total quantity.
 * @property isIsolated  Is is isolated?
 */
@ApiModel("Market order to exit leveraged position.")
data class ForceLiquidationRecord(
@ApiModelProperty("Order id.")
@JsonProperty("orderId") var orderId: Long = 0L,
@ApiModelProperty("Liquidation timestamp in ms.")
@JsonProperty("updatedTime") var updatedTime: Long = 0L,
@ApiModelProperty("Symbol average price.")
@JsonProperty("avgPrice") var avgPrice: String = "",
@ApiModelProperty("Executed quantity.")
@JsonProperty("executedQty") var executedQty: String = "",
@ApiModelProperty("Order time in force.")
@JsonProperty("timeInForce") var timeInForce:TimeInForce?=null,
@ApiModelProperty("Order side.")
@JsonProperty("side") var side:OrderSide?=null,
@ApiModelProperty("Order symbol.")
@JsonProperty("symbol") var symbol: String = "",
@ApiModelProperty("Order price.")
@JsonProperty("price") var price: String = "",
@ApiModelProperty("Order total quantity.")
@JsonProperty("qty") var qty: String = "",
@ApiModelProperty("Is is isolated?") @JsonProperty("isIsolated") var isIsolated: Boolean = false)
{
}