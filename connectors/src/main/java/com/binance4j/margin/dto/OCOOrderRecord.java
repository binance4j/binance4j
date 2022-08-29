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
 val orderListId : Long,
@ApiModelProperty("Transaction timestamp in ms.")
 val transactionTime : Long,
@ApiModelProperty("Related symbol.")
 val symbol : String,
@ApiModelProperty("Contingency type.")
 val contingencyType : String,
@ApiModelProperty("List status type.")
 val listStatusType : String,
@ApiModelProperty("List order status.")
 val listOrderStatus : String,
@ApiModelProperty("List client order id.")
 val listClientOrderId : String,
@ApiModelProperty("Is the order isolated?")
 val isIsoslated : Boolean,
@ApiModelProperty("The two orders.") List<OrderInfo> orders)
{
}
