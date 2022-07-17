package com.binance4j.spot.dto;

import java.util.List;

import com.binance4j.core.dto.ContingencyType;
import com.binance4j.core.dto.OCOOrderStatus;
import com.binance4j.core.dto.OCOStatus;
import com.binance4j.core.dto.OrderInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** An OCO Order details */
@JsonIgnoreProperties(ignoreUnknown = true)
public record OCOInfo(
		/** The order list id. */
		Long orderListId,
		/** The contingency type. */
		ContingencyType contingencyType,
		/** The list status type. */
		OCOStatus listStatusType,
		/** The list order status. */
		OCOOrderStatus listOrderStatus,
		/** The list client order id. */
		String listClientOrderId,
		/** The transaction timestamp in ms. */
		Long transactionTime,
		/** The orders symbol. */
		String symbol,
		/** The two orders of the OCO order. */
		List<OrderInfo> orders) {
}
