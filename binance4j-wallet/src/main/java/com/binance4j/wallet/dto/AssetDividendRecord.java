package com.binance4j.wallet.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An asset divident record.
 * 
 * @param rows  The records.
 * @param total The number of record.
 */
@ApiModel("")
public record AssetDividendRecord(@ApiModelProperty("") List<AssetDividend> rows, @ApiModelProperty("") long total) {
}
