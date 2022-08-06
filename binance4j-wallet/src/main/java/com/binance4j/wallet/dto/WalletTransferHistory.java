package com.binance4j.wallet.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The transfers wrapper.
 * 
 * @param rows  The list of transfers.
 * @param total The result size.
 */
@ApiModel("")
public record WalletTransferHistory(@ApiModelProperty("") List<WalletTransfer> rows, @ApiModelProperty("") long total) {
}