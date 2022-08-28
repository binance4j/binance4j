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
@JsonProperty("orderListId") var orderListId:Long?=null,
@ApiModelProperty("Contingency type.")
@JsonProperty("contingencyType") var contingencyType:String?=null,
@ApiModelProperty("List status type.")
@JsonProperty("listStatusType") var listStatusType:String?=null,
@ApiModelProperty("List order status.")
@JsonProperty("listOrderStatus") var listOrderStatus:String?=null,
@ApiModelProperty("List client order id.")
@JsonProperty("listClientOrderId") var listClientOrderId:String?=null,
@ApiModelProperty("Transaction timestamp in ms.")
@JsonProperty("transactionTime") var transactionTime:Long?=null,
@ApiModelProperty("Orders symbol.")
@JsonProperty("symbol") var symbol:String?=null,
@ApiModelProperty("Two orders of the OCO order.") List<OCOOrder> orders)
{}
