package com.binance4j.wallet.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An asset divident record.
 * 
 * @param rows  Records.
 * @param total Number of record.
 */
@ApiModel("An asset divident record.")
public record AssetDividendRecord(@ApiModelProperty("Records.") List<AssetDividend> rows,
		@ApiModelProperty("Number of record.") long total) {
}
