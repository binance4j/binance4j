package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Trading rules of the exchange.
 * 
 * @param filterType Filter type.
 * @param limit      Filter limit.
 */
@ApiModel("Trading rules of the exchange.")
public record ExchangeFilter(@ApiModelProperty("Trading rules of the exchange.") ExchangeFilterType filterType,
		@ApiModelProperty("Trading rules of the exchange.") int limit) {
}