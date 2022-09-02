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
 val txId : Long,
@ApiModelProperty("Transfered amount.")
 val amount : String,
@ApiModelProperty("Transfered asset.")
 val asset : String,
@ApiModelProperty("Transfer status.")
 val status : String,
@ApiModelProperty("Transaction time in ms.")
 val timestamp : Long,
@ApiModelProperty("Transfer history type.")
 val type : String,
@ApiModelProperty("Transfer counterparty.")
 val transferCounterparty : String,
@ApiModelProperty("Client tag.")
 val clientTag : String)
{
}