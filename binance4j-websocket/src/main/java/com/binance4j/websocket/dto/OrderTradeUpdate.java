package com.binance4j.websocket.dto;

import com.binance4j.core.dto.TimeInForce;

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
public record OrderTradeUpdate(/** The event type. */
String e, Long E, String s, String c, String S, String o, TimeInForce f, String q, String p, String x, String X, String r, Long i, String l, String z, String L,
		String n, String N, Long T, Long t, Long O, String Z, String Y, String Q) {
}