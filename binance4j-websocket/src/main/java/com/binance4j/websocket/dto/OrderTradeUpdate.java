package com.binance4j.websocket.dto;

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
public record OrderTradeUpdate(@JsonProperty("e") String eventType, @JsonProperty("E") Long eventTime, @JsonProperty("s") String symbol,
		@JsonProperty("c") String newClientOrderId, @JsonProperty("S") String side, @JsonProperty("o") String type, @JsonProperty("f") TimeInForce timeInForce,
		@JsonProperty("q") String originalQuantity, @JsonProperty("p") String price, @JsonProperty("x") String executionType,
		@JsonProperty("X") String orderStatus, @JsonProperty("r") String orderRejectReason, @JsonProperty("i") Long orderId,
		@JsonProperty("l") String quantityLastFilledTrade, @JsonProperty("z") String accumulatedQuantity, @JsonProperty("L") String priceOfLastFilledTrade,
		@JsonProperty("n") String commission, @JsonProperty("N") String commissionAsset, @JsonProperty("T") Long orderTradeTime,
		@JsonProperty("t") Long tradeId, @JsonProperty("O") Long orderCreationTime, @JsonProperty("Z") String cumulativeQuoteQuantity,
		@JsonProperty("Y") String lastQuoteQuantity, @JsonProperty("Q") String quoteOrderQuantity) {
}