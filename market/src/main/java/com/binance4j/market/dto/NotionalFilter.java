package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The acceptable notional range allowed for an order on a symbol.
 * 
 * @property maxNotional      Minimum notional value allowed for an order on a
 *                         symbol. An order's notional value is the.
 *                         price * quantity.
 * @property applyMinToMarket Maximum notional value allowed for an order on a
 *                         symbol. An order's notional value is the.
 *                         price * quantity.
 * @property applyMaxToMarket Determines whether the minNotional will be applied to
 *                         MARKET orders.
 * @property avgPriceMins     determines whether the maxNotional will be applied to
 *                         MARKET orders.
 * @property minNotional      Number of minutes the average price is calculated
 *                         over. 0 means the last price is used.
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 *      *
 */
@ApiModel("The acceptable notional range allowed for an order on a symbol.")
data class NotionalFilter(
		@ApiModelProperty("The minimum notional value allowed for an order on a symbol. An order's notional value is the. price * quantity.") String minNotional,
		@ApiModelProperty("The maximum notional value allowed for an order on a symbol. An order's notional value is the. price * quantity.") String maxNotional,
		@ApiModelProperty("Determines whether the minNotional will be applied to MARKET orders.") var applyMinToMarket : Boolean? = null,
		@ApiModelProperty(" determines whether the maxNotional will be applied to MARKET orders.") var applyMaxToMarket : Boolean? = null,
		@ApiModelProperty("Number of minutes the average price is calculated over. 0 means the last price is used.") int avgPriceMins) {
}