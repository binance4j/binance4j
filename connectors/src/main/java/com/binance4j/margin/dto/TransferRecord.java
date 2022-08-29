package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A transfer history record.
 * 
 * @property txId                 Transaction id.
 * @property amount               Transfered amount.
 * @property asset                Transfered asset.
 * @property status               Transfer status.
 * @property timestamp            Transaction time in ms.
 * @property type                 Transfer history type.
 * @property transferCounterparty Transfer counterparty.
 * @property clientTag            Client tag.
 * @see TransferRecordType
 */
@ApiModel("A transfer history record.")
data class TransferRecord(
@ApiModelProperty("Transaction id.")
@JsonProperty("txId") var txId: Long = 0L,
@ApiModelProperty("Transfered amount.")
@JsonProperty("amount") var amount: String = "",
@ApiModelProperty("Transfered asset.")
@JsonProperty("asset") var asset: String = "",
@ApiModelProperty("Transfer status.")
@JsonProperty("status") var status: String = "",
@ApiModelProperty("Transaction time in ms.")
@JsonProperty("timestamp") var timestamp: Long = 0L,
@ApiModelProperty("Transfer history type.")
@JsonProperty("type") var type: String = "",
@ApiModelProperty("Transfer counterparty.")
@JsonProperty("transferCounterparty") var transferCounterparty: String = "",
@ApiModelProperty("Client tag.")
@JsonProperty("clientTag") var clientTag: String = "")
{
}