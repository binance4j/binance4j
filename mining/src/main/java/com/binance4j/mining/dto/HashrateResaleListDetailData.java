package com.binance4j.mining.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Hashrate detail data.
 * 
 * @param configDetails Config details.
 * @param totalNum      Total amount.
 * @param pageSize      Rows per page.
 */
@ApiModel("Hashrate detail data.")
public record HashrateResaleListDetailData(
		@ApiModelProperty("Config details.") List<HashrateResaleListDetail> configDetails,
		@ApiModelProperty("Total amount.") long totalNum, @ApiModelProperty("Rows per page.") long pageSize) {
}