package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.binance4j.core.misc.TimeInForce;
import com.binance4j.core.order.OrderSide;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ForceLiquidation(
		@JsonProperty("avgPrice") BigDecimal averagePrice,
		@JsonProperty("executedQty") BigDecimal executedQuantity,
		long orderId,
		long updatedTime,
		TimeInForce timeInForce,
		OrderSide side,
		String symbol,
		BigDecimal price,
		@JsonProperty("qty") BigDecimal quantity,
		Boolean isIsolated) {
}