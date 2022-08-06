package com.binance4j.margin.dto;

import java.util.Optional;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An executed trade history item.
 * 
 * @param status         Loan status.
 * @param principal      Borrowed quantity.
 * @param isolatedSymbol Isolated symbol. Will not be returned for crossed margin.
 * @param asset          Related asset.
 * @param timestamp      Loan timestamp in ms.
 * @param txId           Transaction id.
 * @see LoanStatus
 */
@ApiModel("An executed trade history item.")
public record Loan(@ApiModelProperty("Loan status.") String status, @ApiModelProperty("Borrowed quantity.") String principal,
		@ApiModelProperty("Isolated symbol. Will not be returned for crossed margin.") Optional<String> isolatedSymbol,
		@ApiModelProperty("Related asset.") String asset, @ApiModelProperty("Loan timestamp in ms.") long timestamp,
		@ApiModelProperty("Transaction id.") long txId) {
}