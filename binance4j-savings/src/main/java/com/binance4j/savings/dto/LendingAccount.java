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
@ApiModel("Lending account.")
public record LendingAccount(@ApiModelProperty("Position amount.") List<PositionAmount> positionAmountVos,
		@ApiModelProperty("Total amount in btc.") String totalAmountInBTC, @ApiModelProperty("Total amount in usdt.") String totalAmountInUSDT,
		@ApiModelProperty("Total fixed amount in btc.") String totalFixedAmountInBTC,
		@ApiModelProperty("Total fixed amount in usdt.") String totalFixedAmountInUSDT, @ApiModelProperty("Total flexible in btc.") String totalFlexibleInBTC,
		@ApiModelProperty("Total flexible in usdt.") String totalFlexibleInUSDT) {
}
