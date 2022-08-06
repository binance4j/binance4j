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
@ApiModel("")
public record HashrateResaleListDetailData(@ApiModelProperty("") List<HashrateResaleListDetail> configDetails, @ApiModelProperty("") long totalNum,
		@ApiModelProperty("") long pageSize) {
}