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
@ApiModel("Account profits data.")
public record AccountProfitsData(@ApiModelProperty("Profits datas.") List<AccountProfit> accountProfits, @ApiModelProperty("Total amount.") long totalNum,
		@ApiModelProperty("Rows per page.") long pageSize) {
}