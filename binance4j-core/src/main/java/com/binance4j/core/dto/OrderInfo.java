package com.binance4j.core.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** Trade order information. */
@JsonIgnoreProperties(ignoreUnknown = true)
public record OrderInfo(
		/** The order side */
		OrderSide side,
		/** Price. */
		BigDecimal price,
		/** Original quantity. */
		BigDecimal origQty,
		/** Original quantity. */
		BigDecimal executedQty,
		/** Used to calculate the average price */
		BigDecimal cummulativeQuoteQty,
		/** Order status. */
		OrderStatus status,
		/** Time in force to indicate how Long will the order remain active. */
		TimeInForce timeInForce,
		/** Type of order. */
		OrderType type,
		/** Used with stop orders. */
		BigDecimal stopPrice,
		/** Used with iceberg orders. */
		BigDecimal icebergQty,
		/** Order timestamp */
		Long time,
		/** Update timestamp. */
		Long updateTime,
		/** Original quote order quantity. */
		BigDecimal origQuoteOrderQty,
		/** is working */
		Boolean isWorking,
		/** is isolated margin */
		Boolean isIsolated,
		/** The order symbol */
		String symbol,
		/** Order id. */
		Long orderId,
		/** Client order id. */
		String clientOrderId) {
}