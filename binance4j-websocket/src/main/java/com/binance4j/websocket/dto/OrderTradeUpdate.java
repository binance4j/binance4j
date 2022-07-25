package com.binance4j.websocket.dto;

import java.math.BigDecimal;

import com.binance4j.core.dto.TimeInForce;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Order or trade report update event.
 * <p>
 * This event is embedded as part of a user data update event.
 *
 * @param eventType               The event type.
 * @param eventTime               The timestamp.
 * @param symbol                  The trading pair.
 * @param newClientOrderId        Client order id.
 * @param side                    Buy/Sell order side.
 * @param type                    Type of order.
 * @param timeInForce             Time in force to indicate how Long will the order remain active.
 * @param originalQuantity        Original quantity in the order.
 * @param price                   Price.
 * @param executionType           Type of execution.
 * @param orderStatus             Status of the order.
 * @param orderRejectReason       Reason why the order was rejected.
 * @param orderId                 Order id.
 * @param quantityLastFilledTrade Quantity of the last filled trade.
 * @param accumulatedQuantity     Accumulated quantity of filled trades on this order.
 * @param priceOfLastFilledTrade  Price of last filled trade.
 * @param commission              Commission.
 * @param commissionAsset         Asset on which commission is taken.
 * @param orderTradeTime          Order/trade time.
 * @param tradeId                 Trade id.
 * @param orderCreationTime       Order creation time.
 * @param cumulativeQuoteQuantity Cumulative quote asset transacted quantity.
 * @param lastQuoteQuantity       Last quote asset transacted quantity (i.e. lastPrice * lastQty).
 * @param quoteOrderQuantity      Quote Order quantity.
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
		@JsonProperty("S") String side,
		/** Type of order. */
		@JsonProperty("o") String type,
		/** Time in force to indicate how Long will the order remain active. */
		@JsonProperty("f") TimeInForce timeInForce,
		/** Original quantity in the order. */
		@JsonProperty("q") BigDecimal originalQuantity,
		/** Price. */
		@JsonProperty("p") BigDecimal price,
		/** Type of execution. */
		@JsonProperty("x") String executionType,
		/** Status of the order. */
		@JsonProperty("X") String orderStatus,
		/** Reason why the order was rejected. */
		@JsonProperty("r") String orderRejectReason,
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
		@JsonProperty("Y") BigDecimal lastQuoteQuantity,
		/** Quote Order quantity. */
		@JsonProperty("Q") BigDecimal quoteOrderQuantity) {
}