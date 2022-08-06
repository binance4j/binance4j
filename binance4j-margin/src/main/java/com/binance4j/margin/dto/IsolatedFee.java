package com.binance4j.margin.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Isolated margin fee.
 * 
 * @param vipLevel VIP level.
 * @param symbol   Related symbol.
 * @param leverage Leverage.
 * @param data     Isolated fee data.
 */
@ApiModel("Isolated margin fee.")
public record IsolatedFee(@ApiModelProperty("VIP level.") int vipLevel, @ApiModelProperty("Related symbol.") String symbol,
		@ApiModelProperty("Leverage.") String leverage, @ApiModelProperty("Isolated fee data.") List<IsolatedFeeData> data) {
}