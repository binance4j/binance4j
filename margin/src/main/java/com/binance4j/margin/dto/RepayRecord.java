package com.binance4j.margin.dto;

import java.util.Optional;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Data about a repay.
 * 
 * @param txId           Transaction id.
 * @param timestamp      Transaction timestamp in ms.
 * @param isolatedSymbol Isolated symbol, will not be returned for crossed
 *                       margin.
 * @param amount         Total amount repaid.
 * @param asset          Asset.
 * @param interest       Interest repaid.
 * @param principal      Quantity repaid.
 * @param status         Repay status.
 * @see LoanStatus
 */
@ApiModel("Data about a repay.")
public record RepayRecord(@ApiModelProperty("Transaction id.") long txId,
		@ApiModelProperty("Transaction timestamp in ms.") long timestamp,
		@ApiModelProperty("Isolated symbol, will not be returned for crossed margin.") Optional<String> isolatedSymbol,
		@ApiModelProperty("Total amount repaid.") String amount, @ApiModelProperty("Asset.") String asset,
		@ApiModelProperty("Interest repaid.") String interest, @ApiModelProperty("Quantity repaid.") String principal,
		@ApiModelProperty("Repay status.") String status) {
}