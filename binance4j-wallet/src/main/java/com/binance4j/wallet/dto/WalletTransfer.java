package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A wallet to wallet transfer.
 * 
 * @param asset     The transfered asset.
 * @param amount    The transfered amount.
 * @param type      The transfer type (origin wallet to destination wallet).
 * @param status    The transfer status.
 * @param tranId    The transaction id.
 * @param timestamp The transfer timestamp.
 * @see WalletTransferType
 */
@ApiModel("")
public record WalletTransfer(@ApiModelProperty("") String asset, @ApiModelProperty("") String amount, @ApiModelProperty("") String type,
		@ApiModelProperty("") String status, @ApiModelProperty("") long tranId, @ApiModelProperty("") long timestamp) {
}
