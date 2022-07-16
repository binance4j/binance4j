package com.binance4j.margin.dto;

import java.util.List;

import com.binance4j.core.order.ContingencyType;
import com.binance4j.core.order.OCOOrderStatus;
import com.binance4j.core.order.OCOStatus;
import com.binance4j.core.order.OrderInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record OCOOrderRecord(
		/** TODO JAVADOC. */
		long orderListId,
		/** TODO JAVADOC. */
		ContingencyType contingencyType,
		/** TODO JAVADOC. */
		OCOStatus listStatusType,
		/** TODO JAVADOC. */
		OCOOrderStatus listOrderStatus,
		/** TODO JAVADOC. */
		String listClientOrderId,
		/** TODO JAVADOC. */
		long transactionTime,
		/** TODO JAVADOC. */
		String symbol,
		/** TODO JAVADOC. */
		boolean isIsoslated,
		/** TODO JAVADOC. */
		List<OrderInfo> orders) {
}
