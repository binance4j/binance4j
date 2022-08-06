package com.binance4j.mining.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Other profits data.
 * 
 * @param otherProfits Profits datas.
 * @param totalNum     Total amount.
 * @param pageSize     Rows per page.
 */
@ApiModel("Other profits data.")
public record OtherProfitsData(@ApiModelProperty("Profits datas.") List<OtherProfit> otherProfits, @ApiModelProperty("Total amount.") long totalNum,
		@ApiModelProperty("Rows per page.") long pageSize) {
}