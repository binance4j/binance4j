package com.binance4j.core.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** The response of an OCO order. */
@JsonIgnoreProperties(ignoreUnknown = true)
public record OCOResponse(
		/** The order list id. */
		Long orderListId,
		/** ??? */
		ContingencyType contingencyType,
		/** The list status. */
		OCOStatus listStatusType,
		/** The list order status. */
		OCOOrderStatus listOrderStatus,
		/** The list client order id. */
		String listClientOrderId,
		/** The order timestamp. */
		Long transactionTime,
		/** The order symbol. */
		String symbol,
		/** The 2 orders. */
		List<MiniOrderInfo> orders,
		/** if isolated margin. */
		Boolean isIsolated,
		/** The order reports. */
		List<OrderReport> orderReports) {
}