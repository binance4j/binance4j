package com.binance4j.spot.dto;

import java.math.BigDecimal;
import java.util.List;

import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.OrderStatus;
import com.binance4j.core.dto.OrderType;
import com.binance4j.core.dto.TimeInForce;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** The response of a SpotOrder */
@JsonIgnoreProperties(ignoreUnknown = true)
public record NewOrderResponse(
		/** The trading pair to trade. */
		String symbol,
		/** The order id. */
		Long orderId,
		/** The order list id. */
		Long orderListId,
		/** The client order id. */
		String clientOrderId,
		/** The order transaction timestamp. */
		Long transactTime,
		/** The price of trade. */
		BigDecimal price,
		/** The original traded quantity. */
		BigDecimal origQty,
		/** The current executed quantity. */
		BigDecimal executedQty,
		/** The opposite coin quantity. */
		String cummulativeQuoteQty,
		/** The order status. */
		OrderStatus status,
		/** How long the order will remain active. */
		TimeInForce timeInForce,
		/** The order type. */
		OrderType type,
		/** The order side. */
		OrderSide side,
		/** The list of trades that partially of fully filled the order. */
		List<OrderTrade> fills) {
}
