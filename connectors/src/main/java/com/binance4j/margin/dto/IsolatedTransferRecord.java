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
@JsonProperty("amount") var amount: String = "",
@ApiModelProperty("Transfered asset.")
@JsonProperty("asset") var asset: String = "",
@ApiModelProperty("Transfer status.")
@JsonProperty("status") var status: String = "",
@ApiModelProperty("Transfer timestamp in ms.")
@JsonProperty("timestamp") var timestamp: Long = 0L,
@ApiModelProperty("Transaction id.")
@JsonProperty("txId") var txId: Long = 0L,
@ApiModelProperty("Account the asset is transfered from.")
@JsonProperty("transFrom") var transFrom: String = "",
@ApiModelProperty("Account the asset is transfered to.")
@JsonProperty("transTo") var transTo: String = "")
{
}