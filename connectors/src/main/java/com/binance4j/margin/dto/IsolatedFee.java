package com.binance4j.margin.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Isolated margin fee.
 * 
 * @property vipLevel VIP level.
 * @property symbol   Related symbol.
 * @property leverage Leverage.
 * @property data     Isolated fee data.
 */
@ApiModel("Isolated margin fee.")
data class IsolatedFee(
@ApiModelProperty("VIP level.")
@JsonProperty("vipLevel") var vipLevel:Int = 0,
@ApiModelProperty("Related symbol.")
@JsonProperty("symbol") var symbol: String = "",
@ApiModelProperty("Leverage.")
@JsonProperty("leverage") var leverage: String = "",
@ApiModelProperty("Isolated fee data.") List<IsolatedFeeData> data)
{
}