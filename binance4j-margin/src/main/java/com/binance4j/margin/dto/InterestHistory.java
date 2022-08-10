package com.binance4j.margin.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Interest History containing {@link InterestRecord InterestRecords}.
 * 
 * @param total Total number of records.
 * @param rows  Interest records.
 */
@ApiModel("Interest History containing InterestRecord InterestRecords.")
public record InterestHistory(@ApiModelProperty("Total number of records.") int total,
		@ApiModelProperty("Interest records.") List<InterestRecord> rows) {
}