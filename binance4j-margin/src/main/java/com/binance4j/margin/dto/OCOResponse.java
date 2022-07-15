package com.binance4j.margin.dto;

import java.math.BigDecimal;
import java.util.List;

import com.binance4j.core.order.ContingencyType;
import com.binance4j.core.order.MiniOrderInfo;
import com.binance4j.core.order.OCOOrderStatus;
import com.binance4j.core.order.OCOStatus;
import com.binance4j.core.order.OrderReport;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public record OCOResponse(
		/** will not return if no margin trade happens. */
		BigDecimal marginBuyBorrowAmount,
		/** will not return if no margin trade happens. */
		BigDecimal marginBuyBorrowAsset,
		/** The order list id. */
		long orderListId,
		/** ??? */
		ContingencyType contingencyType,
		/** The list status. */
		OCOStatus listStatusType,
		/** The list order status. */
		OCOOrderStatus listOrderStatus,
		/** The list client order id. */
		String listClientOrderId,
		/** The order timestamp. */
		long transactionTime,
		/** The order symbol. */
		String symbol,
		/** The 2 orders. */
		List<MiniOrderInfo> orders,
		/** Is isolated margin. */
		boolean isIsolated,
		/** The order reports. */
		List<OrderReport> orderReports) {
}