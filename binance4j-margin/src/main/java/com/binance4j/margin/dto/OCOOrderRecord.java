package com.binance4j.margin.dto;

import java.util.List;

import com.binance4j.core.order.ContingencyType;
import com.binance4j.core.order.OCOOrderStatus;
import com.binance4j.core.order.OCOStatus;
import com.binance4j.core.order.OrderInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * An OCO order record
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
@JsonIgnoreProperties(ignoreUnknown = true)
public record OCOOrderRecord(
		/** The order list id. */
		long orderListId,
		/** The transaction timestamp in ms. */
		long transactionTime,
		/** The related symbol. */
		String symbol,
		/** The contingency type. */
		ContingencyType contingencyType,
		/** The list status type. */
		OCOStatus listStatusType,
		/** The list order status. */
		OCOOrderStatus listOrderStatus,
		/** The list client order id. */
		String listClientOrderId,
		/** Is the order isolated? */
		boolean isIsoslated,
		/** The two orders. */
		List<OrderInfo> orders) {
}
