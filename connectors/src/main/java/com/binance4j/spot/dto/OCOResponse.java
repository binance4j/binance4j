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
 val orderListId : Long,
@ApiModelProperty("Contingency type.")
 val contingencyType : String,
@ApiModelProperty("List status.")
 val listStatusType : String,
@ApiModelProperty("List order status.")
 val listOrderStatus : String,
@ApiModelProperty("List client order id.")
 val listClientOrderId : String,
@ApiModelProperty("Order timestamp.")
 val transactionTime : Long,
@ApiModelProperty("Order symbol.")
 val symbol : String,
@ApiModelProperty("The 2 orders.") List<MiniOrderInfo> orders,
@ApiModelProperty("is it an isolated trade?")
 val isIsolated : Boolean,
@ApiModelProperty("Order reports.") List<OCOOrderReport> orderReports)
{
}