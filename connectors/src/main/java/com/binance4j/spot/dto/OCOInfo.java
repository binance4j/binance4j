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
 val orderListId : Long,
@ApiModelProperty("Contingency type.")
 val contingencyType : String,
@ApiModelProperty("List status type.")
 val listStatusType : String,
@ApiModelProperty("List order status.")
 val listOrderStatus : String,
@ApiModelProperty("List client order id.")
 val listClientOrderId : String,
@ApiModelProperty("Transaction timestamp in ms.")
 val transactionTime : Long,
@ApiModelProperty("Orders symbol.")
 val symbol : String,
@ApiModelProperty("Two orders of the OCO order.") List<OCOOrder> orders)
{}
