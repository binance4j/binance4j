package com.binance4j.savings.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Lending account.
 * 
 * @property positionAmountVos      Position amount.
 * @property totalAmountInBTC       Total amount in btc.
 * @property totalAmountInUSDT      Total amount in usdt.
 * @property totalFixedAmountInBTC  Total fixed amount in btc.
 * @property totalFixedAmountInUSDT Total fixed amount in usdt.
 * @property totalFlexibleInBTC     Total flexible in btc.
 * @property totalFlexibleInUSDT    Total flexible in usdt.
 */
@ApiModel("Lending account.")
data class LendingAccount(@ApiModelProperty("Position amount.") List<PositionAmount> positionAmountVos,
		@ApiModelProperty("Total amount in btc.") var totalAmountInBTC : String? = null,
		@ApiModelProperty("Total amount in usdt.") var totalAmountInUSDT : String? = null,
		@ApiModelProperty("Total fixed amount in btc.") var totalFixedAmountInBTC : String? = null,
		@ApiModelProperty("Total fixed amount in usdt.") var totalFixedAmountInUSDT : String? = null,
		@ApiModelProperty("Total flexible in btc.") var totalFlexibleInBTC : String? = null,
		@ApiModelProperty("Total flexible in usdt.") var totalFlexibleInUSDT : String? = null) {
}
