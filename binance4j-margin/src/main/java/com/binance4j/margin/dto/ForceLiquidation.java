package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.binance4j.core.misc.TimeInForce;
import com.binance4j.core.order.OrderSide;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ForceLiquidation(
		/** TODO JAVADOC. */
		@JsonProperty("avgPrice") BigDecimal averagePrice,
		/** TODO JAVADOC. */
		@JsonProperty("executedQty") BigDecimal executedQuantity,
		/** TODO JAVADOC. */
		long orderId,
		/** TODO JAVADOC. */
		long updatedTime,
		/** TODO JAVADOC. */
		TimeInForce timeInForce,
		/** TODO JAVADOC. */
		OrderSide side,
		/** TODO JAVADOC. */
		String symbol,
		/** TODO JAVADOC. */
		BigDecimal price,
		/** TODO JAVADOC. */
		@JsonProperty("qty") BigDecimal quantity,
		/** TODO JAVADOC. */
		boolean isIsolated) {
}