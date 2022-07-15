package com.binance4j.margin.dto;

import java.math.BigDecimal;
import java.util.List;

import com.binance4j.core.misc.TimeInForce;
import com.binance4j.core.order.OrderSide;
import com.binance4j.core.order.OrderStatus;
import com.binance4j.core.order.OrderType;
import com.binance4j.core.order.Trade;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** Data returned after an order */
@JsonIgnoreProperties(ignoreUnknown = true)
public record OrderResponse(
		/** TODO JAVADOC. */
		OrderSide side,
		/** TODO JAVADOC. */
		OrderStatus status,
		/** TODO JAVADOC. */
		OrderType type,
		/** TODO JAVADOC. */
		TimeInForce timeInForce,
		/** TODO JAVADOC. */
		String symbol,
		/** TODO JAVADOC. */
		long orderId,
		/** TODO JAVADOC. */
		long transactTime,
		/** TODO JAVADOC. */
		BigDecimal clientOrderId,
		/** TODO JAVADOC. */
		BigDecimal price,
		/** TODO JAVADOC. */
		BigDecimal origQty,
		/** TODO JAVADOC. */
		BigDecimal executedQty,
		/** TODO JAVADOC. */
		BigDecimal cummulativeQuoteQty,
		/** TODO JAVADOC. */
		BigDecimal marginBuyBorrowAmount,
		/** TODO JAVADOC. */
		BigDecimal marginBuyBorrowAsset,
		/** TODO JAVADOC. */
		boolean isIsolated,
		/** TODO JAVADOC. */
		List<Trade> fills) {
}