package com.binance4j.spot.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An OCO Order details.
 * 
 * @param orderListId       Order list id.
 * @param contingencyType   Contingency type.
 * @param listStatusType    List status type.
 * @param listOrderStatus   List order status.
 * @param listClientOrderId List client order id.
 * @param transactionTime   Transaction timestamp in ms.
 * @param symbol            Orders symbol.
 * @param orders            Two orders of the OCO order.
 */
@ApiModel("An OCO Order details.")
public record OCOInfo(@ApiModelProperty("Order list id.") long orderListId, @ApiModelProperty("Contingency type.") String contingencyType,
		@ApiModelProperty("List status type.") String listStatusType, @ApiModelProperty("List order status.") String listOrderStatus,
		@ApiModelProperty("List client order id.") String listClientOrderId, @ApiModelProperty("Transaction timestamp in ms.") long transactionTime,
		@ApiModelProperty("Orders symbol.") String symbol, @ApiModelProperty("Two orders of the OCO order.") List<OCOOrder> orders) {}
