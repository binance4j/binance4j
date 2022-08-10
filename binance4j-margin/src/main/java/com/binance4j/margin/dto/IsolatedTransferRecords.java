package com.binance4j.margin.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Isolated margin transfer records.
 * 
 * @param rows  Transfers.
 * @param total Total records.
 */
@ApiModel("Isolated margin transfer records.")
public record IsolatedTransferRecords(@ApiModelProperty("Transfers.") List<IsolatedTransferRecord> rows,
		@ApiModelProperty("Total records.") int total) {
}