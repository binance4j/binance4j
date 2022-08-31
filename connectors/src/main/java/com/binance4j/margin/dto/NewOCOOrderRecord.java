package com.binance4j.margin.dto;

;
import java.util.Optional;

import com.binance4j.core.dto.OrderReport;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Record of a newly placed OCO order.
 * 
 * @property orderListId           Order list id.
 * @property contingencyType       Contingency type.
 * @property listStatusType        List status.
 * @property listOrderStatus       List order status.
 * @property listClientOrderId     List client order id.
 * @property transactionTime       Order timestamp.
 * @property symbol                Order symbol.
 * @property marginBuyBorrowAmount Margin buy borrow amount. Will not return if no
 *                              margin trade happens.
 * @property marginBuyBorrowAsset  Margin buy borrow asset. Will not return if no
 *                              margin trade happens.
 * @property isIsolated            Is the order isolated?
 * @property orders                The 2 orders.
 * @property orderReports          Order reports.
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@ApiModel("Record of a newly placed OCO order.")
data class NewOCOOrderRecord(
@ApiModelProperty("Order list id.")
 val orderListId : Long,
@ApiModelProperty("Contingency type.")
 val contingencyType : String,
@ApiModelProperty("List status.")
 val listStatusType : String,
@ApiModelProperty("List order status.")
 val listOrderStatus : String,
@ApiModelProperty("List client order id.")
 val listClientOrderId : String,
@ApiModelProperty("Order timestamp.")
 val transactionTime : Long,
@ApiModelProperty("Order symbol.")
 val symbol : String,
@ApiModelProperty("Margin buy borrow amount. Will not return if no margin trade happens.") Optional<String> marginBuyBorrowAmount,
@ApiModelProperty("Margin buy borrow asset. Will not return if no margin trade happens.")
Optional<String> marginBuyBorrowAsset,
@ApiModelProperty("Is the order isolated?")
 val isIsolated : Boolean,
@ApiModelProperty("The 2 orders.")
List<MiniOrderInfo> orders,
@ApiModelProperty("Order reports.")
List<OrderReport> orderReports)
{
}