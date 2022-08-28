package com.binance4j.margin.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Isolated margin transfer records.
 * 
 * @property rows  Transfers.
 * @property total Total records.
 */
@ApiModel("Isolated margin transfer records.")
data class IsolatedTransferRecords(@ApiModelProperty("Transfers.") List<IsolatedTransferRecord> rows,
		@ApiModelProperty("Total records.") @JsonProperty("total ") var total : Int? = null) {
}