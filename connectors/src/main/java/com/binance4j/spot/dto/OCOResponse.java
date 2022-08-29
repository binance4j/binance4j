package com.binance4j.spot.dto;

import java.util.List;

import com.binance4j.core.dto.MiniOrderInfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Response of an OCO order.
 * 
 * @property orderListId       Order list id.
 * @property contingencyType   Contingency type.
 * @property listStatusType    List status.
 * @property listOrderStatus   List order status.
 * @property listClientOrderId List client order id.
 * @property transactionTime   Order timestamp.
 * @property symbol            Order symbol.
 * @property orders            The 2 orders.
 * @property isIsolated        Is it an isolated trade?
 * @property orderReports      Order reports.
 */
@ApiModel("Response of an OCO order.")
data class OCOResponse(
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
@ApiModelProperty("The 2 orders.") List<MiniOrderInfo> orders,
@ApiModelProperty("is it an isolated trade?")
@JsonProperty("isIsolated") var isIsolated: Boolean = false,
@ApiModelProperty("Order reports.") List<OCOOrderReport> orderReports)
{
}