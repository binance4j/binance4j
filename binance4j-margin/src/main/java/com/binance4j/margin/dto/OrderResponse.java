package com.binance4j.margin.dto;

import java.math.BigDecimal;
import java.util.List;

import com.binance4j.core.misc.TimeInForce;
import com.binance4j.core.order.OrderSide;
import com.binance4j.core.order.OrderStatus;
import com.binance4j.core.order.OrderType;
import com.binance4j.core.order.Trade;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Data returned after an order
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record OrderResponse(
		OrderSide side,
		OrderStatus status,
		OrderType type,
		TimeInForce timeInForce,
		String symbol,
		Long orderId,
		Long transactTime,
		BigDecimal clientOrderId,
		BigDecimal price,
		BigDecimal origQty,
		BigDecimal executedQty,
		BigDecimal cummulativeQuoteQty,
		BigDecimal marginBuyBorrowAmount,
		BigDecimal marginBuyBorrowAsset,
		Boolean isIsolated,
		List<Trade> fills) {
}