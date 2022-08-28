package com.binance4j.spot.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * OCO order infos.
 * 
 * @param symbol        symbol.
 * @param orderId       order id.
 * @param clientOrderId client order id.
 */
@ApiModel("OCO order infos.")
public record OCOOrder(@ApiModelProperty("symbol.") String symbol, @ApiModelProperty("order id.") long orderId,
		@ApiModelProperty("client order id.") String clientOrderId) {
}
