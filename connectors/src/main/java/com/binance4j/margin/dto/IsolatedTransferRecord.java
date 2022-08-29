package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An asset transfer record between two accounts.
 * 
 * @property amount    Transfered amount.
 * @property asset     Transfered asset.
 * @property status    Transfer status.
 * @property timestamp Transfer timestamp in ms.
 * @property txId      Transaction id.
 * @property transFrom Account the asset is transfered from.
 * @property transTo   Account the asset is transfered to.
 * @see IsolatedTransferAccount
 */
@ApiModel("An asset transfer record between two accounts.")
data class IsolatedTransferRecord(
@ApiModelProperty("Transfered amount.")
 val amount : String,
@ApiModelProperty("Transfered asset.")
 val asset : String,
@ApiModelProperty("Transfer status.")
 val status : String,
@ApiModelProperty("Transfer timestamp in ms.")
 val timestamp : Long,
@ApiModelProperty("Transaction id.")
 val txId : Long,
@ApiModelProperty("Account the asset is transfered from.")
 val transFrom : String,
@ApiModelProperty("Account the asset is transfered to.")
 val transTo : String)
{
}