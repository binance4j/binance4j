package com.binance4j.core.dto;

/**
 * The CancelOrder request result.
 * 
 * @param status              Status.
 * @param side                Side.
 * @param type                Type.
 * @param timeInForce         Time in force.
 * @param orderId             Order id.
 * @param orderListId         Order list id.
 * @param symbol              Symbol.
 * @param origClientOrderId   Orig client order id.
 * @param clientOrderId       Client order id.
 * @param executedQty         Executed quantity.
 * @param price               Price.
 * @param origQty             Original quantity.
 * @param cummulativeQuoteQty Cummulative quote quantity.
 * @param isIsolated          Is isolated.
 */
public record CancelOrderResponse(String status, String side, String type, String timeInForce, long orderId, long orderListId, String symbol,
		String origClientOrderId, String clientOrderId, String executedQty, String price, String origQty, String cummulativeQuoteQty, boolean isIsolated) {
}