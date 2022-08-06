package com.binance4j.margin.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A {@link ForceLiquidationRecord} records container.
 * 
 * @param rows  Records.
 * @param total Total number of records.
 */
@ApiModel("ForceLiquidationRecord records container.")
public record ForceLiquidationRecords(@ApiModelProperty("Records.") List<ForceLiquidationRecord> rows,
		@ApiModelProperty("Total number of records.") int total) {
}