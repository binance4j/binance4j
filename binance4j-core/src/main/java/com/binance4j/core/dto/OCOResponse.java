package com.binance4j.core.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties(ignoreUnknown = true)
public record OCOResponse(
		/** The order list id. */
		long orderListId,
		/** The contingency type */
		String contingencyType,
		/** The list status. */
		String listStatusType,
		/** The list order status. */
		String listOrderStatus,
		/** The list client order id. */
		String listClientOrderId,
		/** The order timestamp. */
		long transactionTime,
		/** The order symbol. */
		String symbol,
		/** The 2 orders. */
		List<MiniOrderInfo> orders,
		/** is it an isolated trade? */
		boolean isIsolated,
		/** The order reports. */
		List<OrderReport> orderReports) {
}