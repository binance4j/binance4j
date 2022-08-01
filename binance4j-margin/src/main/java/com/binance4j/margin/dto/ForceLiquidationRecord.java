package com.binance4j.margin.dto;

import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.TimeInForce;

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
public record ForceLiquidationRecord(long orderId, long updatedTime, String avgPrice, String executedQty, TimeInForce timeInForce, OrderSide side,
		String symbol, String price, String qty, boolean isIsolated) {
}