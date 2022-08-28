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
var orderListId:Long?=null,
@ApiModelProperty("Contingency type.")
var contingencyType:String?=null,
@ApiModelProperty("List status.")
var listStatusType:String?=null,
@ApiModelProperty("List order status.")
var listOrderStatus:String?=null,
@ApiModelProperty("List client order id.")
var listClientOrderId:String?=null,
@ApiModelProperty("Order timestamp.")
var transactionTime:Long?=null,
@ApiModelProperty("Order symbol.")
var symbol:String?=null,
@ApiModelProperty("The 2 orders.") List<MiniOrderInfo> orders,
@ApiModelProperty("is it an isolated trade?")
var isIsolated:Boolean?=null,
@ApiModelProperty("Order reports.") List<OCOOrderReport> orderReports)
{
}