package com.binance4j.mining.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Account profits data.
 * 
 * @property accountProfits Profits datas.
 * @property totalNum       Total amount.
 * @property pageSize       Rows per page.
 */
@ApiModel("Account profits data.")
data class AccountProfitsData(@ApiModelProperty("Profits datas.") List<AccountProfit> accountProfits,
		@ApiModelProperty("Total amount.") @JsonProperty("totalNum ") var totalNum : Long? = null,
		@ApiModelProperty("Rows per page.") @JsonProperty("pageSize ") var pageSize : Long? = null) {
}