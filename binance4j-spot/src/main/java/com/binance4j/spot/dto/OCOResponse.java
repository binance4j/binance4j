package com.binance4j.spot.dto;

import java.util.List;

import com.binance4j.core.dto.MiniOrderInfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Response of an OCO order.
 * 
 * @param orderListId       Order list id.
 * @param contingencyType   Contingency type.
 * @param listStatusType    List status.
 * @param listOrderStatus   List order status.
 * @param listClientOrderId List client order id.
 * @param transactionTime   Order timestamp.
 * @param symbol            Order symbol.
 * @param orders            The 2 orders.
 * @param isIsolated        Is it an isolated trade?
 * @param orderReports      Order reports.
 */
@ApiModel("Response of an OCO order.")
public record OCOResponse(@ApiModelProperty("Order list id.") long orderListId, @ApiModelProperty("Contingency type.") String contingencyType,
		@ApiModelProperty("List status.") String listStatusType, @ApiModelProperty("List order status.") String listOrderStatus,
		@ApiModelProperty("List client order id.") String listClientOrderId, @ApiModelProperty("Order timestamp.") long transactionTime,
		@ApiModelProperty("Order symbol.") String symbol, @ApiModelProperty("The 2 orders.") List<MiniOrderInfo> orders,
		@ApiModelProperty("is it an isolated trade?") boolean isIsolated, @ApiModelProperty("Order reports.") List<OCOOrderReport> orderReports) {
}