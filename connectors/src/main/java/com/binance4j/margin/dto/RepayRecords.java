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
 var total:Int = 0,
@ApiModelProperty("Repays.") List<RepayRecord> rows)
{
}