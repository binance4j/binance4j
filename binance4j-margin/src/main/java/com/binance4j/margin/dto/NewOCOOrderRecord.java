package com.binance4j.margin.dto;

import java.util.List;
import java.util.Optional;

import com.binance4j.core.dto.OrderReport;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Record of a newly placed OCO order.
 * 
 * @param orderListId           Order list id.
 * @param contingencyType       Contingency type.
 * @param listStatusType        List status.
 * @param listOrderStatus       List order status.
 * @param listClientOrderId     List client order id.
 * @param transactionTime       Order timestamp.
 * @param symbol                Order symbol.
 * @param marginBuyBorrowAmount Margin buy borrow amount. Will not return if no
 *                              margin trade happens.
 * @param marginBuyBorrowAsset  Margin buy borrow asset. Will not return if no
 *                              margin trade happens.
 * @param isIsolated            Is the order isolated?
 * @param orders                The 2 orders.
 * @param orderReports          Order reports.
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@ApiModel("Record of a newly placed OCO order.")
public record NewOCOOrderRecord(@ApiModelProperty("Order list id.") long orderListId,
		@ApiModelProperty("Contingency type.") String contingencyType,
		@ApiModelProperty("List status.") String listStatusType,
		@ApiModelProperty("List order status.") String listOrderStatus,
		@ApiModelProperty("List client order id.") String listClientOrderId,
		@ApiModelProperty("Order timestamp.") long transactionTime,
		@ApiModelProperty("Order symbol.") String symbol,
		@ApiModelProperty("Margin buy borrow amount. Will not return if no margin trade happens.") Optional<String> marginBuyBorrowAmount,
		@ApiModelProperty("Margin buy borrow asset. Will not return if no margin trade happens.") Optional<String> marginBuyBorrowAsset,
		@ApiModelProperty("Is the order isolated?") boolean isIsolated,
		@ApiModelProperty("The 2 orders.") List<MiniOrderInfo> orders,
		@ApiModelProperty("Order reports.") List<OrderReport> orderReports) {
}