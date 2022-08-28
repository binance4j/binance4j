package com.binance4j.mining.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Other profits data.
 * 
 * @property otherProfits Profits datas.
 * @property totalNum     Total amount.
 * @property pageSize     Rows per page.
 */
@ApiModel("Other profits data.")
data class OtherProfitsData(@ApiModelProperty("Profits datas.") List<OtherProfit> otherProfits,
		@ApiModelProperty("Total amount.") var totalNum : Long? = null,
		@ApiModelProperty("Rows per page.") var pageSize : Long? = null) {
}