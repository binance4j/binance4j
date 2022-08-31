package com.binance4j.margin.dto;

;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A loan record.
 * 
 * @property total Total records.
 * @property rows  Records.
 */
@ApiModel("A loan record.")
data class LoanRecord(
@ApiModelProperty("Total records.")
 var total:Int,
@ApiModelProperty("Records.") List<Loan> rows)
{
}