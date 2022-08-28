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
var amount:String?=null,
@ApiModelProperty("Transfered asset.")
var asset:String?=null,
@ApiModelProperty("Transfer status.")
var status:String?=null,
@ApiModelProperty("Transfer timestamp in ms.")
var timestamp:Long?=null,
@ApiModelProperty("Transaction id.")
var txId:Long?=null,
@ApiModelProperty("Account the asset is transfered from.")
var transFrom:String?=null,
@ApiModelProperty("Account the asset is transfered to.")
var transTo:String?=null)
{
}