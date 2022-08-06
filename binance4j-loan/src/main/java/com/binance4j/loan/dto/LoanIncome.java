package com.binance4j.loan.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A loan income.
 * 
 * @param asset     Income asset.
 * @param type      Income type.
 * @param amount    Income maount.
 * @param timestamp Timestamp in ms.
 * @param tranId    Transaction id.
 */
@ApiModel("A loan income.")
public record LoanIncome(@ApiModelProperty("Income asset.") String asset, @ApiModelProperty("Income type.") String type,
		@ApiModelProperty("Income maount.") String amount, @ApiModelProperty("Timestamp in ms.") long timestamp,
		@ApiModelProperty("Transaction id.") String tranId) {
}