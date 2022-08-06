package com.binance4j.mining.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Account profits data.
 * 
 * @param accountProfits Profits datas.
 * @param totalNum       Total amount.
 * @param pageSize       Rows per page.
 */
@ApiModel("")
public record AccountProfitsData(@ApiModelProperty("") List<AccountProfit> accountProfits, @ApiModelProperty("") long totalNum,
		@ApiModelProperty("") long pageSize) {
}