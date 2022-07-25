package com.binance4j.spot.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The response of a SpotOrder.
 * 
 * @param symbol                   The trading pair to trade.
 * @param orderId                  The order id.
 * @param orderListId              The order list id.
 * @param clientOrderId            The client order id.
 * @param transactTime             The order transaction timestamp.
 * @param price                    The price of trade.
 * @param origQuantity             The original traded quantity.
 * @param executedQuantity         The current executed quantity.
 * @param cummulativeQuoteQuantity The opposite coin quantity.
 * @param status                   The order status.
 * @param timeInForce              How long the order will remain active.
 * @param type                     The order type.
 * @param side                     The order side.
 * @param fills                    The list of trades that partially of fully filled the order.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record NewOrderResponse(
		/** The trading pair to trade. */
		String symbol,
		/** The order id. */
		long orderId,
		/** The order list id. */
		long orderListId,
		/** The client order id. */
		String clientOrderId,
		/** The order transaction timestamp. */
		long transactTime,
		/** The price of trade. */
		BigDecimal price,
		/** The original traded quantity. */
		@JsonProperty("origQty") BigDecimal origQuantity,
		/** The current executed quantity. */
		@JsonProperty("executedQty") BigDecimal executedQuantity,
		/** The opposite coin quantity. */
		@JsonProperty("cummulativeQuoteQty") String cummulativeQuoteQuantity,
		/** The order status. */
		String status,
		/** How long the order will remain active. */
		String timeInForce,
		/** The order type. */
		String type,
		/** The order side. */
		String side,
		/** The list of trades that partially of fully filled the order. */
		List<OrderTrade> fills) {
}
