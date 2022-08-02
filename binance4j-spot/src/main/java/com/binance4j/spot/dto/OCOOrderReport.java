package com.binance4j.spot.dto;

/**
 * OCO order report.
 * 
 * @param symbol              Symbol.
 * @param orderId             Order Id.
 * @param orderListId         Order List Id.
 * @param clientOrderId       Client Order Id.
 * @param transactTime        Transact Time.
 * @param price               Price.
 * @param origQty             Original Quantity.
 * @param executedQty         Executed Quantity.
 * @param cummulativeQuoteQty Cummulative Quote Quantity.
 * @param status              Status.
 * @param timeInForce         Time In Force.
 * @param type                Type.
 * @param side                Side.
 * @param stopPrice           StopPrice.
 */
public record OCOOrderReport(String symbol, long orderId, long orderListId, String clientOrderId, long transactTime, String price, String origQty,
		String executedQty, String cummulativeQuoteQty, String status, String timeInForce, String type, String side, String stopPrice) {
}
