package com.binance4j.spot.dto;

import java.util.List;

import com.binance4j.core.dto.MiniOrderInfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
@ApiModel("")
public record OCOResponse(@ApiModelProperty("") long orderListId, @ApiModelProperty("") String contingencyType, @ApiModelProperty("") String listStatusType,
		@ApiModelProperty("") String listOrderStatus, @ApiModelProperty("") String listClientOrderId, @ApiModelProperty("") long transactionTime,
		@ApiModelProperty("") String symbol, @ApiModelProperty("") List<MiniOrderInfo> orders, @ApiModelProperty("") boolean isIsolated,
		@ApiModelProperty("") List<OCOOrderReport> orderReports) {
}