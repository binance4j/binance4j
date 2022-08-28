package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The user universal transfer response.
 * 
 * @param tranId Transaction id.
 */
@ApiModel("The user universal transfer response.")
public record WalletTransferResponse(@ApiModelProperty("Transaction id.") long tranId) {
}