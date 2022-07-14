package com.binance4j.margin.dto;

import java.util.List;

import com.binance4j.core.order.ContingencyType;
import com.binance4j.core.order.OCOOrderStatus;
import com.binance4j.core.order.OCOStatus;
import com.binance4j.core.order.OrderInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GetMarginOCOResponse(
		Long orderListId,
		ContingencyType contingencyType,
		OCOStatus listStatusType,
		OCOOrderStatus listOrderStatus,
		String listClientOrderId,
		Long transactionTime,
		String symbol,
		Boolean isIsoslated,
		List<OrderInfo> orders) {
}
