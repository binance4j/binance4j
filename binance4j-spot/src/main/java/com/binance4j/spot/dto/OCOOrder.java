package com.binance4j.spot.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * OCO infos.
 * 
 * @param symbol        symbol.
 * @param orderId       order id.
 * @param clientOrderId client order id.
 */
@ApiModel("")
public record OCOOrder(@ApiModelProperty("") String symbol, @ApiModelProperty("") long orderId, @ApiModelProperty("") String clientOrderId) {
}
