package com.binance4j.fiat.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A fiat transaction.
 * 
 * @param orderNo         Order No.
 * @param fiatCurrency    Fiat currency.
 * @param indicatedAmount Indicated amount.
 * @param amount          Amount.
 * @param totalFee        Total fee.
 * @param method          Method.
 * @param status          Status.
 * @param createTime      Create time in ms.
 * @param updateTime      Update time in ms.
 */
@ApiModel("A fiat transaction.")
public record Transaction(@ApiModelProperty("Order No.") String orderNo, @ApiModelProperty("Fiat currency.") String fiatCurrency,
		@ApiModelProperty("Indicated amount.") String indicatedAmount, @ApiModelProperty("Amount.") String amount,
		@ApiModelProperty("Total fee.") String totalFee, @ApiModelProperty("Method.") String method, @ApiModelProperty("Status.") String status,
		@ApiModelProperty("Create time in ms.") long createTime, @ApiModelProperty("Update time in ms.") long updateTime) {
}
