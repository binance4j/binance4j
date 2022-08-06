package com.binance4j.spot.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An OCO Order details.
 * 
 * @param orderListId       The order list id.
 * @param contingencyType   The contingency type.
 * @param listStatusType    The list status type.
 * @param listOrderStatus   The list order status.
 * @param listClientOrderId The list client order id.
 * @param transactionTime   The transaction timestamp in ms.
 * @param symbol            The orders symbol.
 * @param orders            The two orders of the OCO order.
 */
@ApiModel("")
public record OCOInfo(@ApiModelProperty("") long orderListId, @ApiModelProperty("") String contingencyType, @ApiModelProperty("") String listStatusType,
		@ApiModelProperty("") String listOrderStatus, @ApiModelProperty("") String listClientOrderId, @ApiModelProperty("") long transactionTime,
		@ApiModelProperty("") String symbol, @ApiModelProperty("") List<OCOOrder> orders) {
}
