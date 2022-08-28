package com.binance4j.spot.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An OCO Order details.
 * 
 * @property orderListId       Order list id.
 * @property contingencyType   Contingency type.
 * @property listStatusType    List status type.
 * @property listOrderStatus   List order status.
 * @property listClientOrderId List client order id.
 * @property transactionTime   Transaction timestamp in ms.
 * @property symbol            Orders symbol.
 * @property orders            Two orders of the OCO order.
 */
@ApiModel("An OCO Order details.")
data class OCOInfo(
@ApiModelProperty("Order list id.")
var orderListId:Long?=null,
@ApiModelProperty("Contingency type.")
var contingencyType:String?=null,
@ApiModelProperty("List status type.")
var listStatusType:String?=null,
@ApiModelProperty("List order status.")
var listOrderStatus:String?=null,
@ApiModelProperty("List client order id.")
var listClientOrderId:String?=null,
@ApiModelProperty("Transaction timestamp in ms.")
var transactionTime:Long?=null,
@ApiModelProperty("Orders symbol.")
var symbol:String?=null,
@ApiModelProperty("Two orders of the OCO order.") List<OCOOrder> orders)
{}
