package com.binance4j.margin.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A list of transfer history records.
 * 
 * @param total Total of records.
 * @param rows  Records.
 */
@ApiModel("A list of transfer history records.")
public record TransferRecords(@ApiModelProperty("Total of records.") int total,
		@ApiModelProperty("The records.") List<TransferRecord> rows) {
}