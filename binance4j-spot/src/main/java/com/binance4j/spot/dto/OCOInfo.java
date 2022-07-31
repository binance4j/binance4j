package com.binance4j.spot.dto;

import java.util.List;

import com.binance4j.core.dto.OrderInfo;

/**
 * An OCO Order details.
 * 
 * @param orderListId       The order list id.
 * @param contingencyType   The contingency type.
 * @param listStatusType    The list status type.
 * @param listOrderStatus   The list order status.
 * @param listClientOrderId The list client order id.
 * @param transactionTime   The transaction timestamp in ms.
 * @param symbol            The orders symbol.
 * @param orders            The two orders of the OCO order.
 */
public record OCOInfo(long orderListId, String contingencyType, String listStatusType, String listOrderStatus, String listClientOrderId, long transactionTime,
		String symbol, List<OrderInfo> orders) {
}
