package com.binance4j.margin.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A repay record.
 * 
 * @param total Total of repays.
 * @param rows  Repays.
 */
@ApiModel("A repay record.")
public record RepayRecords(@ApiModelProperty("Total of repays.") int total, @ApiModelProperty("Repays.") List<RepayRecord> rows) {
}