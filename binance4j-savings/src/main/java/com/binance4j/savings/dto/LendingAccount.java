package com.binance4j.savings.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Lending account.
 * 
 * @param positionAmountVos      Position amount.
 * @param totalAmountInBTC       Total amount in btc.
 * @param totalAmountInUSDT      Total amount in usdt.
 * @param totalFixedAmountInBTC  Total fixed amount in btc.
 * @param totalFixedAmountInUSDT Total fixed amount in usdt.
 * @param totalFlexibleInBTC     Total flexible in btc.
 * @param totalFlexibleInUSDT    Total flexible in usdt.
 */
@ApiModel("")
public record LendingAccount(@ApiModelProperty("") List<PositionAmount> positionAmountVos, @ApiModelProperty("") String totalAmountInBTC,
		@ApiModelProperty("") String totalAmountInUSDT, @ApiModelProperty("") String totalFixedAmountInBTC, @ApiModelProperty("") String totalFixedAmountInUSDT,
		@ApiModelProperty("") String totalFlexibleInBTC, @ApiModelProperty("") String totalFlexibleInUSDT) {
}
