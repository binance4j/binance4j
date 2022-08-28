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
@ApiModel("Hashrate detail data.")
public record HashrateResaleDetailData(@ApiModelProperty("Details.") List<HashrateResaleDetail> profitTransferDetails,
		@ApiModelProperty("Total amount.") long totalNum, @ApiModelProperty("Rows per page.") long pageSize) {
}