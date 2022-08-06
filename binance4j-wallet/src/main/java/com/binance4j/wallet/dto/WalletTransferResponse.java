package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The user universal transfer response.
 * 
 * @param tranId The transaction id.
 */
@ApiModel("")
public record WalletTransferResponse(@ApiModelProperty("") long tranId) {
}