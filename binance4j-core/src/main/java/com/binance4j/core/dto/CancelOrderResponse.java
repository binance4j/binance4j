package com.binance4j.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The CancelOrder request result. */
@JsonIgnoreProperties(ignoreUnknown = true)
public record CancelOrderResponse(
		/** The order status. */
		String status,
		/** The order side. */
		String side,
		/** The order type. */
		String type,
		/** The order timeInForce. */
		String timeInForce,
		/** The order id. */
		long orderId,
		/** The order list. */
		long orderListId,
		/** The order symbol. */
		String symbol,
		/** The original client order id. */
		String origClientOrderId,
		/** The client order id. */
		String clientOrderId,
		/** The order executed quantity. */
		@JsonProperty("executedQty") String executedQuantity,
		/** The order price. */
		String price,
		/** The order original quantity. */
		@JsonProperty("origQty") String origQuantity,
		/** The order cumulative quote quantity. */
		@JsonProperty("cummulativeQuoteQty") String cummulativeQuoteQuantity,
		/** Is the order margin isolated. */
		boolean isIsolated) {
}