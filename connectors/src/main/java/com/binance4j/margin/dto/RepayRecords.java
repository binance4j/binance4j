package com.binance4j.margin.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A repay record.
 * 
 * @property total Total of repays.
 * @property rows  Repays.
 */
@ApiModel("A repay record.")
data class RepayRecords(
@ApiModelProperty("Total of repays.")
@JsonProperty("total") var total:int?=null,
@ApiModelProperty("Repays.") List<RepayRecord> rows)
{
}