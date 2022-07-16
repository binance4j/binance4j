package com.binance4j.margin.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.OrderStatus;
import com.binance4j.core.dto.OrderType;
import com.binance4j.core.dto.TimeInForce;
import com.binance4j.core.dto.Trade;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An newly placed order record.
 * 
 * @param orderId               The order id.
 * @param symbol                The traded symbol.
 * @param side                  The order side.
 * @param status                The order status.
 * @param type                  The order type.
 * @param timeInForce           The order time in force.
 * @param transactionTime       The transaction time.
 * @param clientOrderId         The client order id.
 * @param price                 The symbol price.
 * @param originalQuantity      The order original quantity.
 * @param executedQuantity      The order executed quantity.
 * @param cummulativeQuoteQty   The cumulative quote quantity.
 * @param marginBuyBorrowAmount The margin buy borrow amount. Will not return if no margin trade happens.
 * @param marginBuyBorrowAsset  The margin buy borrow asset. Will not return if no margin trade happens.
 * @param isIsolated            Is the order isolated?
 * @param fills                 The filled trades.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record NewOrderRecord(
		/** The order id. */
		long orderId,
		/** The traded symbol. */
		String symbol,
		/** The order side. */
		OrderSide side,
		/** The order status. */
		OrderStatus status,
		/** The order type. */
		OrderType type,
		/** The order time in force. */
		TimeInForce timeInForce,
		/** The transaction time. */
		@JsonProperty("transactTime") long transactionTime,
		/** The client order id. */
		BigDecimal clientOrderId,
		/** The symbol price. */
		BigDecimal price,
		/** The order original quantity. */
		@JsonProperty("origQty") BigDecimal originalQuantity,
		/** The order executed quantity. */
		@JsonProperty("executedQty") BigDecimal executedQuantity,
		/** The cumulative quote quantity. */
		BigDecimal cummulativeQuoteQty,
		/** The margin buy borrow amount. Will not return if no margin trade happens. */
		Optional<BigDecimal> marginBuyBorrowAmount,
		/** The margin buy borrow asset. Will not return if no margin trade happens. */
		Optional<BigDecimal> marginBuyBorrowAsset,
		/** Is the order isolated? */
		boolean isIsolated,
		/** The filled trades. */
		List<Trade> fills) {
}