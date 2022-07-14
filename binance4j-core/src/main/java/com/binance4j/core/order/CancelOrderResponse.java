package com.binance4j.core.order;

import java.math.BigDecimal;

import com.binance4j.core.misc.TimeInForce;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** The CancelOrder request result */
@JsonIgnoreProperties(ignoreUnknown = true)
public record CancelOrderResponse(
		/** The order status */
		OrderStatus status,
		/** The order side */
		OrderSide side,
		/** The order type */
		OrderType type,
		/** The order timeInForce */
		TimeInForce timeInForce,
		/** The order id */
		Long orderId,
		/** The order list */
		Long orderListId,
		/** The order symbol */
		String symbol,
		/** The original client order id */
		String origClientOrderId,
		/** The client order id */
		String clientOrderId,
		/** The order executed quantity */
		String executedQty,
		/** The order price */
		BigDecimal price,
		/** The order original quantity */
		BigDecimal origQty,
		/** The order cumulative quote quantity */
		BigDecimal cummulativeQuoteQty,
		/** Is the order margin isolated */
		Boolean isIsolated) {
}