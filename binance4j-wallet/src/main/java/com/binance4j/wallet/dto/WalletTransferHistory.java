package com.binance4j.wallet.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The transfers wrapper.
 * 
 * @param rows  List of transfers.
 * @param total Result size.
 */
@ApiModel("The transfers wrapper.")
public record WalletTransferHistory(@ApiModelProperty("List of transfers.") List<WalletTransfer> rows,
		@ApiModelProperty("Result size.") long total) {
}