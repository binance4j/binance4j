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
 * @property orderListId           Order list id.
 * @property contingencyType       Contingency type.
 * @property listStatusType        List status.
 * @property listOrderStatus       List order status.
 * @property listClientOrderId     List client order id.
 * @property transactionTime       Order timestamp.
 * @property symbol                Order symbol.
 * @property marginBuyBorrowAmount Margin buy borrow amount. Will not return if no
 *                              margin trade happens.
 * @property marginBuyBorrowAsset  Margin buy borrow asset. Will not return if no
 *                              margin trade happens.
 * @property isIsolated            Is the order isolated?
 * @property orders                The 2 orders.
 * @property orderReports          Order reports.
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@ApiModel("Record of a newly placed OCO order.")
data class NewOCOOrderRecord(
@ApiModelProperty("Order list id.")
@JsonProperty("orderListId") var orderListId: Long = 0L,
@ApiModelProperty("Contingency type.")
@JsonProperty("contingencyType") var contingencyType: String = "",
@ApiModelProperty("List status.")
@JsonProperty("listStatusType") var listStatusType: String = "",
@ApiModelProperty("List order status.")
@JsonProperty("listOrderStatus") var listOrderStatus: String = "",
@ApiModelProperty("List client order id.")
@JsonProperty("listClientOrderId") var listClientOrderId: String = "",
@ApiModelProperty("Order timestamp.")
@JsonProperty("transactionTime") var transactionTime: Long = 0L,
@ApiModelProperty("Order symbol.")
@JsonProperty("symbol") var symbol: String = "",
@ApiModelProperty("Margin buy borrow amount. Will not return if no margin trade happens.") Optional<String> marginBuyBorrowAmount,
@ApiModelProperty("Margin buy borrow asset. Will not return if no margin trade happens.")
Optional<String> marginBuyBorrowAsset,
@ApiModelProperty("Is the order isolated?")
@JsonProperty("isIsolated") var isIsolated: Boolean = false,
@ApiModelProperty("The 2 orders.")
List<MiniOrderInfo> orders,
@ApiModelProperty("Order reports.")
List<OrderReport> orderReports)
{
}