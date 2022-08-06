package com.binance4j.portfoliomargin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** Margin portfolio account infos */
@ApiModel("")
public record AccountInfo(@ApiModelProperty("") String uniMMR, @ApiModelProperty("") String accountEquity, @ApiModelProperty("") String accountMaintMargin,
		@ApiModelProperty("")
		/**
		 * Portfolio margin account status.
		 * <p>
		 * Enum: NORMAL,@ApiModelProperty("") MARGIN_CALL,@ApiModelProperty("") SUPPLY_MARGIN,@ApiModelProperty("")
		 * REDUCE_ONLY,@ApiModelProperty("") ACTIVE_LIQUIDATION,@ApiModelProperty("") FORCE_LIQUIDATION,@ApiModelProperty("")
		 * BANKRUPTED
		 */
		String accountStatus) {
}
