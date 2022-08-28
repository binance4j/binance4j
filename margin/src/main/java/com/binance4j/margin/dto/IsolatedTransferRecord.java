package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An asset transfer record between two accounts.
 * 
 * @param amount    Transfered amount.
 * @param asset     Transfered asset.
 * @param status    Transfer status.
 * @param timestamp Transfer timestamp in ms.
 * @param txId      Transaction id.
 * @param transFrom Account the asset is transfered from.
 * @param transTo   Account the asset is transfered to.
 * @see IsolatedTransferAccount
 */
@ApiModel("An asset transfer record between two accounts.")
public record IsolatedTransferRecord(@ApiModelProperty("Transfered amount.") String amount,
		@ApiModelProperty("Transfered asset.") String asset,
		@ApiModelProperty("Transfer status.") String status,
		@ApiModelProperty("Transfer timestamp in ms.") long timestamp,
		@ApiModelProperty("Transaction id.") long txId,
		@ApiModelProperty("Account the asset is transfered from.") String transFrom,
		@ApiModelProperty("Account the asset is transfered to.") String transTo) {
}