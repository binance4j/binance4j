package com.binance4j.margin.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A {@link ForceLiquidationRecord} records container.
 * 
 * @property rows  Records.
 * @property total Total number of records.
 */
@ApiModel("ForceLiquidationRecord records container.")
data class ForceLiquidationRecords(@ApiModelProperty("Records.") List<ForceLiquidationRecord> rows,
		@ApiModelProperty("Total number of records.") @JsonProperty("total ") var total : Int = 0) {
}