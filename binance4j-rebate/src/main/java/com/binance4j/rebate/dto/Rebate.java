package com.binance4j.rebate.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A rebate
 * 
 * @param asset      The rebate asset.
 * @param type       The rebate type.
 * @param amount     The rebate amount.
 * @param updateTime The rebate update time.
 * @see RebateType
 */
@ApiModel("")
public record Rebate(@ApiModelProperty("") String asset, @ApiModelProperty("") String type, @ApiModelProperty("") String amount,
		@ApiModelProperty("") long updateTime) {
}
