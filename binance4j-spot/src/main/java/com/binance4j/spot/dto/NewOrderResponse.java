package com.binance4j.spot.dto;

import java.util.List;

import com.binance4j.spot.client.SpotClient;

/**
 * {@link SpotClient#newOrder} response.
 * 
 * @param symbol              The trading pair to trade.
 * @param orderId             The order id.
 * @param orderListId         The order list id.
 * @param clientOrderId       The client order id.
 * @param transactTime        The order transaction timestamp.
 * @param price               The price of trade.
 * @param origQty             The original traded quantity.
 * @param executedQty         The current executed quantity.
 * @param cummulativeQuoteQty The opposite coin quantity.
 * @param status              The order status.
 * @param timeInForce         How long the order will remain active.
 * @param type                The order type.
 * @param side                The order side.
 * @param fills               The list of trades that partially of fully filled the order.
 */
public record NewOrderResponse(String symbol, long orderId, long orderListId, String clientOrderId, long transactTime, String price, String origQty,
		String executedQty, String cummulativeQuoteQty, String status, String timeInForce, String type, String side, List<OrderTrade> fills) {
}
