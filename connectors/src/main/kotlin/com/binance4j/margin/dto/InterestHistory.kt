package com.binance4j.margin.dto;

;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Interest History containing {@link InterestRecord InterestRecords}.
 * 
 * @property total Total number of records.
 * @property rows  Interest records.
 */
@ApiModel("Interest History containing InterestRecord InterestRecords.")
data class InterestHistory(
@ApiModelProperty("Total number of records.")
 var total:Int,
@ApiModelProperty("Interest records.") List<InterestRecord> rows)
{
}