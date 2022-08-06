package com.binance4j.mining.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Hashrate detail data.
 * 
 * @param profitTransferDetails Details.
 * @param totalNum              Total amount.
 * @param pageSize              Rows per page.
 */
@ApiModel("")
public record HashrateResaleDetailData(@ApiModelProperty("") List<HashrateResaleDetail> profitTransferDetails, @ApiModelProperty("") long totalNum,
		@ApiModelProperty("") long pageSize) {
}