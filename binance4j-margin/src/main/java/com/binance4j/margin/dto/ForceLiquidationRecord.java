package com.binance4j.margin.dto;

import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.TimeInForce;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Market order to exit leveraged position
 * 
 * @param orderId          The order id.
 * @param updatedTime      The liquidation timestamp in ms.
 * @param averagePrice     The symbol average price.
 * @param executedQuantity The executed quantity.
 * @param timeInForce      The order time in force.
 * @param side             The order side.
 * @param symbol           The order symbol.
 * @param price            The order price.
 * @param quantity         The order total quantity.
 * @param isIsolated       Is is isolated?
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ForceLiquidationRecord(
		/** The order id */
		long orderId,
		/** The liquidation timestamp in ms. */
		long updatedTime,
		/** The symbol average price. */
		@JsonProperty("avgPrice") String averagePrice,
		/** The executed quantity. */
		@JsonProperty("executedQty") String executedQuantity,
		/** The order time in force. */
		TimeInForce timeInForce,
		/** The order side. */
		OrderSide side,
		/** The order symbol. */
		String symbol,
		/** The order price. */
		String price,
		/** The order total quantity. */
		@JsonProperty("qty") String quantity,
		/** Is is isolated? */
		boolean isIsolated) {
}