package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Trading rules of the exchange.
 * 
 * @property filterType Filter type.
 * @property limit      Filter limit.
 */
@ApiModel("Trading rules of the exchange.")
data class ExchangeFilter(
@ApiModelProperty("Trading rules of the exchange.")
 var filterType:ExchangeFilterType?=null,
@ApiModelProperty("Trading rules of the exchange.")  var limit:Int = 0)
{
}