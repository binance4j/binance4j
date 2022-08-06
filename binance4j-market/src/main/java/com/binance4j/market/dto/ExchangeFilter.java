package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Trading rules of the exchange.
 * 
 * @param filterType The filter type.
 * @param limit      The filter limit.
 */
@ApiModel("")
public record ExchangeFilter(@ApiModelProperty("") ExchangeFilterType filterType, @ApiModelProperty("") int limit) {
}