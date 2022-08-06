package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Isolated fee data.
 * 
 * @param coin          Related coin.
 * @param dailyInterest Daily interest.
 * @param borrowLimit   Borrow limit.
 */
@ApiModel("Isolated fee data.")
public record IsolatedFeeData(@ApiModelProperty("Related coin.") String coin, @ApiModelProperty("Daily interest.") String dailyInterest,
		@ApiModelProperty("Borrow limit.") String borrowLimit) {
}