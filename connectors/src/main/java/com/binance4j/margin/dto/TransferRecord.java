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
@JsonProperty("txId") var txId:Long?=null,
@ApiModelProperty("Transfered amount.")
@JsonProperty("amount") var amount:String?=null,
@ApiModelProperty("Transfered asset.")
@JsonProperty("asset") var asset:String?=null,
@ApiModelProperty("Transfer status.")
@JsonProperty("status") var status:String?=null,
@ApiModelProperty("Transaction time in ms.")
@JsonProperty("timestamp") var timestamp:Long?=null,
@ApiModelProperty("Transfer history type.")
@JsonProperty("type") var type:String?=null,
@ApiModelProperty("Transfer counterparty.")
@JsonProperty("transferCounterparty") var transferCounterparty:String?=null,
@ApiModelProperty("Client tag.")
@JsonProperty("clientTag") var clientTag:String?=null)
{
}