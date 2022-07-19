package com.binance4j.websocket.dto;

import java.math.BigDecimal;

import com.binance4j.core.dto.ExecutionType;
import com.binance4j.core.dto.OrderRejectReason;
import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.OrderStatus;
import com.binance4j.core.dto.OrderType;
import com.binance4j.core.dto.TimeInForce;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Order or trade report update event.
 * <p>
 * This event is embedded as part of a user data update event.
 *
 * @see UserDataUpdate
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public record OrderTradeUpdate(/** The event type. */
@JsonProperty("e") String eventType,
		/** The timestamp. */
		@JsonProperty("E") Long eventTime,
		/** The trading pair. */
		@JsonProperty("s") String symbol,
		/** Client order id. */
		@JsonProperty("c") String newClientOrderId,
		/** Buy/Sell order side. */
		@JsonProperty("S") OrderSide side,
		/** Type of order. */
		@JsonProperty("o") OrderType type,
		/** Time in force to indicate how Long will the order remain active. */
		@JsonProperty("f") TimeInForce timeInForce,
		/** Original quantity in the order. */
		@JsonProperty("q") BigDecimal originalQuantity,
		/** Price. */
		@JsonProperty("p") BigDecimal price,
		/** Type of execution. */
		@JsonProperty("x") ExecutionType executionType,
		/** Status of the order. */
		@JsonProperty("X") OrderStatus orderStatus,
		/** Reason why the order was rejected. */
		@JsonProperty("r") OrderRejectReason orderRejectReason,
		/** Order id. */
		@JsonProperty("i") Long orderId,
		/** Quantity of the last filled trade. */
		@JsonProperty("l") BigDecimal quantityLastFilledTrade,
		/** Accumulated quantity of filled trades on this order. */
		@JsonProperty("z") BigDecimal accumulatedQuantity,
		/** Price of last filled trade. */
		@JsonProperty("L") BigDecimal priceOfLastFilledTrade,
		/** Commission. */
		@JsonProperty("n") BigDecimal commission,
		/** Asset on which commission is taken. */
		@JsonProperty("N") String commissionAsset,
		/** Order/trade time. */
		@JsonProperty("T") Long orderTradeTime,
		/** Trade id. */
		@JsonProperty("t") Long tradeId,
		/** Order creation time. */
		@JsonProperty("O") Long orderCreationTime,
		/** Cumulative quote asset transacted quantity. */
		@JsonProperty("Z") BigDecimal cumulativeQuoteQuantity,
		/** Last quote asset transacted quantity (i.e. lastPrice * lastQty). */
		@JsonProperty("Y") BigDecimal lastQuoteQuantity, /** Quote Order quantity. */
		@JsonProperty("Q") BigDecimal quoteOrderQuantity) {
}