package com.binance4j.mining.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Workers data.
 * 
 * @property accountProfits Profits datas.
 * @property totalNum       Total amount.
 * @property pageSize       Rows per page.
 */
@ApiModel("Workers data.")
data class ProfitsData(@ApiModelProperty("Profits datas.") List<Profit> accountProfits,
		@ApiModelProperty("Total amount.") var totalNum : Long? = null,
		@ApiModelProperty("Rows per page.") var pageSize : Long? = null) {
}