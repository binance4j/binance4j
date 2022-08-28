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
@JsonProperty("orderListId") var orderListId:Long?=null,
@ApiModelProperty("Transaction timestamp in ms.")
@JsonProperty("transactionTime") var transactionTime:Long?=null,
@ApiModelProperty("Related symbol.")
@JsonProperty("symbol") var symbol:String?=null,
@ApiModelProperty("Contingency type.")
@JsonProperty("contingencyType") var contingencyType:String?=null,
@ApiModelProperty("List status type.")
@JsonProperty("listStatusType") var listStatusType:String?=null,
@ApiModelProperty("List order status.")
@JsonProperty("listOrderStatus") var listOrderStatus:String?=null,
@ApiModelProperty("List client order id.")
@JsonProperty("listClientOrderId") var listClientOrderId:String?=null,
@ApiModelProperty("Is the order isolated?")
@JsonProperty("isIsoslated") var isIsoslated:Boolean?=null,
@ApiModelProperty("The two orders.") List<OrderInfo> orders)
{
}
