package com.binance4j.rebate.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A rebate.
 * 
 * @param asset      Rebate asset.
 * @param type       Rebate type.
 * @param amount     Rebate amount.
 * @param updateTime Rebate update time.
 * @see RebateType
 */
@ApiModel("A rebate.")
public record Rebate(@ApiModelProperty("Rebate asset.") String asset, @ApiModelProperty("Rebate type.") String type,
		@ApiModelProperty("Rebate amount.") String amount, @ApiModelProperty("Rebate update time.") long updateTime) {
}
