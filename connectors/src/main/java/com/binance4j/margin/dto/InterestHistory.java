package com.binance4j.margin.dto;

import java.util.List;

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
@JsonProperty("total") var total:Int = 0,
@ApiModelProperty("Interest records.") List<InterestRecord> rows)
{
}