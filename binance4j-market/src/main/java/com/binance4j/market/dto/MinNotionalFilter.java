package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The minimum notional value allowed for an order on a symbol.
 * 
 * @param minNotional   Minimum notional value allowed for an order on a symbol. An order's notional value is the. price
 *                          * quantity.
 * @param applyToMarket Whether or not the filter is applied to MARKET orders.
 * @param avgPriceMins  Number of minutes the average price is calculated over. 0 means the last price is used.
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 */
@ApiModel("The minimum notional value allowed for an order on a symbol.")
public record MinNotionalFilter(
		@ApiModelProperty("The minimum notional value allowed for an order on a symbol. An order's notional value is the price * quantity.") String minNotional,
		@ApiModelProperty("Whether or not the filter is applied to MARKET orders.") boolean applyToMarket,
		@ApiModelProperty("The number of minutes the average price is calculated over. 0 means the last price is used.") int avgPriceMins) {
}