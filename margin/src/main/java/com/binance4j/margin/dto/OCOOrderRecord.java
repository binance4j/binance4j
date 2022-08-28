package com.binance4j.margin.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An OCO order record.
 * 
 * @property orderListId       Order list id.
 * @property transactionTime   Transaction timestamp in ms.
 * @property symbol            Related symbol.
 * @property contingencyType   Contingency type.
 * @property listStatusType    List status type.
 * @property listOrderStatus   List order status.
 * @property listClientOrderId List client order id.
 * @property isIsoslated       Is the order isolated?
 * @property orders            Two orders.
 */
@ApiModel("An OCO order record.")
data class OCOOrderRecord(
@ApiModelProperty("Order list id.")
var orderListId:Long?=null,
@ApiModelProperty("Transaction timestamp in ms.")
var transactionTime:Long?=null,
@ApiModelProperty("Related symbol.")
var symbol:String?=null,
@ApiModelProperty("Contingency type.")
var contingencyType:String?=null,
@ApiModelProperty("List status type.")
var listStatusType:String?=null,
@ApiModelProperty("List order status.")
var listOrderStatus:String?=null,
@ApiModelProperty("List client order id.")
var listClientOrderId:String?=null,
@ApiModelProperty("Is the order isolated?")
var isIsoslated:Boolean?=null,
@ApiModelProperty("The two orders.") List<OrderInfo> orders)
{
}
