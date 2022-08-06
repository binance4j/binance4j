package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A wallet to wallet transfer.
 * 
 * @param asset     Transfered asset.
 * @param amount    Transfered amount.
 * @param type      Transfer type (origin wallet to destination wallet).
 * @param status    Transfer status.
 * @param tranId    Transaction id.
 * @param timestamp Transfer timestamp.
 * @see WalletTransferType
 */
@ApiModel("A wallet to wallet transfer.")
public record WalletTransfer(@ApiModelProperty("Transfered asset.") String asset, @ApiModelProperty("Transfered amount.") String amount,
		@ApiModelProperty("Transfer type (origin wallet to destination wallet).") String type, @ApiModelProperty("Transfer status.") String status,
		@ApiModelProperty("Transaction id.") long tranId, @ApiModelProperty("Transfer timestamp.") long timestamp) {
}
