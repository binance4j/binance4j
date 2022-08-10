package com.binance4j.margin.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An OCO order record.
 * 
 * @param orderListId       Order list id.
 * @param transactionTime   Transaction timestamp in ms.
 * @param symbol            Related symbol.
 * @param contingencyType   Contingency type.
 * @param listStatusType    List status type.
 * @param listOrderStatus   List order status.
 * @param listClientOrderId List client order id.
 * @param isIsoslated       Is the order isolated?
 * @param orders            Two orders.
 */
@ApiModel("An OCO order record.")
public record OCOOrderRecord(@ApiModelProperty("Order list id.") long orderListId,
		@ApiModelProperty("Transaction timestamp in ms.") long transactionTime,
		@ApiModelProperty("Related symbol.") String symbol,
		@ApiModelProperty("Contingency type.") String contingencyType,
		@ApiModelProperty("List status type.") String listStatusType,
		@ApiModelProperty("List order status.") String listOrderStatus,
		@ApiModelProperty("List client order id.") String listClientOrderId,
		@ApiModelProperty("Is the order isolated?") boolean isIsoslated,
		@ApiModelProperty("The two orders.") List<OrderInfo> orders) {
}
