package com.binance4j.core.dto;

import java.util.List;

/**
 * The response of an OCO order.
 * 
 * @param orderListId       The order list id.
 * @param contingencyType   The contingency type.
 * @param listStatusType    The list status.
 * @param listOrderStatus   The list order status.
 * @param listClientOrderId The list client order id.
 * @param transactionTime   The order timestamp.
 * @param symbol            The order symbol.
 * @param orders            The 2 orders.
 * @param isIsolated        is it an isolated trade?
 * @param orderReports      The order reports.
 */
public record OCOResponse(long orderListId, String contingencyType, String listStatusType, String listOrderStatus, String listClientOrderId,
		long transactionTime, String symbol, List<MiniOrderInfo> orders, boolean isIsolated, List<OrderReport> orderReports) {
}