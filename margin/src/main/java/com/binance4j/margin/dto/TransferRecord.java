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
var txId:Long?=null,
@ApiModelProperty("Transfered amount.")
var amount:String?=null,
@ApiModelProperty("Transfered asset.")
var asset:String?=null,
@ApiModelProperty("Transfer status.")
var status:String?=null,
@ApiModelProperty("Transaction time in ms.")
var timestamp:Long?=null,
@ApiModelProperty("Transfer history type.")
var type:String?=null,
@ApiModelProperty("Transfer counterparty.")
var transferCounterparty:String?=null,
@ApiModelProperty("Client tag.")
var clientTag:String?=null)
{
}