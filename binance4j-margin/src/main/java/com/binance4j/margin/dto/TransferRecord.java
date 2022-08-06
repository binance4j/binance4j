package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A transfer history record.
 * 
 * @param txId                 Transaction id.
 * @param amount               Transfered amount.
 * @param asset                Transfered asset.
 * @param status               Transfer status.
 * @param timestamp            Transaction time in ms.
 * @param type                 Transfer history type.
 * @param transferCounterparty Transfer counterparty.
 * @param clientTag            Client tag.
 * @see TransferRecordType
 */
@ApiModel("A transfer history record.")
public record TransferRecord(@ApiModelProperty("Transaction id.") long txId, @ApiModelProperty("Transfered amount.") String amount,
		@ApiModelProperty("Transfered asset.") String asset, @ApiModelProperty("Transfer status.") String status,
		@ApiModelProperty("Transaction time in ms.") long timestamp, @ApiModelProperty("Transfer history type.") String type,
		@ApiModelProperty("Transfer counterparty.") String transferCounterparty, @ApiModelProperty("Client tag.") String clientTag) {
}