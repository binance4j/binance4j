package com.binance4j.margin.dto;

import java.util.List;

import com.binance4j.core.dto.OrderInfo;

/**
 * An OCO order record.
 * 
 * @param orderListId       The order list id.
 * @param transactionTime   The transaction timestamp in ms.
 * @param symbol            The related symbol.
 * @param contingencyType   The contingency type.
 * @param listStatusType    The list status type.
 * @param listOrderStatus   The list order status.
 * @param listClientOrderId The list client order id.
 * @param isIsoslated       Is the order isolated?
 * @param orders            The two orders.
 */
public record OCOOrderRecord(long orderListId, long transactionTime, String symbol, String contingencyType, String listStatusType, String listOrderStatus,
		String listClientOrderId, boolean isIsoslated, List<OrderInfo> orders) {
}
