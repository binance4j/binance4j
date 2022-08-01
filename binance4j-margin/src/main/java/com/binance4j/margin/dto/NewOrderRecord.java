package com.binance4j.margin.dto;

import java.util.List;
import java.util.Optional;

import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.Trade;

/**
 * An newly placed order record.
 * 
 * @param orderId                  The order id.
 * @param symbol                   The traded symbol.
 * @param side                     The order side.
 * @param status                   The order status.
 * @param type                     The order type.
 * @param timeInForce              The order time in force.
 * @param transactionTime          The transaction time.
 * @param clientOrderId            The client order id.
 * @param price                    The symbol price.
 * @param originalQuantity         The order original quantity.
 * @param executedQuantity         The order executed quantity.
 * @param cummulativeQuoteQuantity The cumulative quote quantity.
 * @param marginBuyBorrowAmount    The margin buy borrow amount. Will not return if no margin trade happens.
 * @param marginBuyBorrowAsset     The margin buy borrow asset. Will not return if no margin trade happens.
 * @param isIsolated               Is the order isolated?
 * @param fills                    The filled trades.
 */
public record NewOrderRecord(long orderId, String symbol, OrderSide side, String status, String type, String timeInForce, long transactTime,
		String clientOrderId, String price, String origQty, String executedQty, String cummulativeQuoteQty, Optional<String> marginBuyBorrowAmount,
		Optional<String> marginBuyBorrowAsset, boolean isIsolated, List<Trade> fills) {
}