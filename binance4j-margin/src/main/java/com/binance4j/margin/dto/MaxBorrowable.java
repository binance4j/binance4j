package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Max Borrowable amount.
 * 
 * @param amount      Account's currently max borrowable amount with sufficient system availability.
 * @param borrowLimit Max borrowable amount limited by the account level.
 */
@ApiModel("Max Borrowable amount.")
public record MaxBorrowable(@ApiModelProperty("Account's currently max borrowable amount with sufficient system availability.") String amount,
		@ApiModelProperty("Max borrowable amount limited by the account level.") String borrowLimit) {
}