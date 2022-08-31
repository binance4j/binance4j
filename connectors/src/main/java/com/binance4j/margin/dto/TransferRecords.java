package com.binance4j.margin.dto;

;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A list of transfer history records.
 * 
 * @property total Total of records.
 * @property rows  Records.
 */
@ApiModel("A list of transfer history records.")
data class TransferRecords(
@ApiModelProperty("Total of records.")
 var total:Int,
@ApiModelProperty("The records.") List<TransferRecord> rows)
{
}