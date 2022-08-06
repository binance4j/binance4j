package com.binance4j.mining.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Workers data.
 * 
 * @param accountProfits Profits datas.
 * @param totalNum       Total amount.
 * @param pageSize       Rows per page.
 */
@ApiModel("Workers data.")
public record ProfitsData(@ApiModelProperty("Profits datas.") List<Profit> accountProfits, @ApiModelProperty("Total amount.") long totalNum,
		@ApiModelProperty("Rows per page.") long pageSize) {
}