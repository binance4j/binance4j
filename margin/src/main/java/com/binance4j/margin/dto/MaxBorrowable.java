package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Max Borrowable amount.
 * 
 * @property amount      Account's currently max borrowable amount with sufficient
 *                    system availability.
 * @property borrowLimit Max borrowable amount limited by the account level.
 */
@ApiModel("Max Borrowable amount.")
data class MaxBorrowable(
		@ApiModelProperty("Account's currently max borrowable amount with sufficient system availability.") String amount,
		@ApiModelProperty("Max borrowable amount limited by the account level.") var borrowLimit : String? = null) {
}