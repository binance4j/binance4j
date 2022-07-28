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
public record OCOOrderRecord(
		/** The order list id. */
		long orderListId,
		/** The transaction timestamp in ms. */
		long transactionTime,
		/** The related symbol. */
		String symbol,
		/** The contingency type. */
		String contingencyType,
		/** The list status type. */
		String listStatusType,
		/** The list order status. */
		String listOrderStatus,
		/** The list client order id. */
		String listClientOrderId,
		/** Is the order isolated? */
		boolean isIsoslated,
		/** The two orders. */
		List<OrderInfo> orders) {
}
