package com.binance4j.fiat.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Transaction history.
 * 
 * @param code    Code.
 * @param message Message.
 * @param data    Transactions.
 * @param total   Total.
 * @param success Success.
 */
@ApiModel("Transaction history.")
public record TransactionHistory(@ApiModelProperty("Code.") String code, @ApiModelProperty("Message.") String message,
		@ApiModelProperty("Transactions.") List<Transaction> data, @ApiModelProperty("Total.") int total,
		@ApiModelProperty("Success.") boolean success) {
}
