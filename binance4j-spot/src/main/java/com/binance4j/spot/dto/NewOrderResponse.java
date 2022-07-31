package com.binance4j.spot.dto;

import java.util.List;
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
public record NewOrderResponse(String symbol, long orderId, long orderListId, String clientOrderId, long transactTime, String price,
		@JsonProperty("origQty") String origQuantity, @JsonProperty("executedQty") String executedQuantity,
		@JsonProperty("cummulativeQuoteQty") String cummulativeQuoteQuantity, String status, String timeInForce, String type, String side,
		List<OrderTrade> fills) {
}
