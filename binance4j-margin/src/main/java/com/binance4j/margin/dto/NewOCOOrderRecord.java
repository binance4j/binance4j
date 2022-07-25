package com.binance4j.margin.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.binance4j.core.dto.OrderReport;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

/**
 * Record of a newly placed OCO order.
 * 
 * @param orderListId           The order list id.
 * @param contingencyType       The contingency type.
 * @param listStatusType        The list status.
 * @param listOrderStatus       The list order status.
 * @param listClientOrderId     The list client order id.
 * @param transactionTime       The order timestamp.
 * @param symbol                The order symbol.
 * @param marginBuyBorrowAmount The margin buy borrow amount. Will not return if no margin trade happens.
 * @param marginBuyBorrowAsset  The margin buy borrow asset. Will not return if no margin trade happens.
 * @param isIsolated            Is the order isolated?
 * @param orders                The 2 orders.
 * @param orderReports          The order reports.
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public record NewOCOOrderRecord(
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
		/** The margin buy borrow amount. Will not return if no margin trade happens. */
		Optional<BigDecimal> marginBuyBorrowAmount,
		/** The margin buy borrow asset. Will not return if no margin trade happens. */
		Optional<BigDecimal> marginBuyBorrowAsset,
		/** Is the order isolated? */
		boolean isIsolated,
		/** The 2 orders. */
		List<MiniOrderInfo> orders,
		/** The order reports. */
		List<OrderReport> orderReports) {
}