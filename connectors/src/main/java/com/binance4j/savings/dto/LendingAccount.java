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
		@ApiModelProperty("Total amount in btc.") @JsonProperty("totalAmountInBTC ") var totalAmountInBTC : String = "",
		@ApiModelProperty("Total amount in usdt.") @JsonProperty("totalAmountInUSDT ") var totalAmountInUSDT : String = "",
		@ApiModelProperty("Total fixed amount in btc.") @JsonProperty("totalFixedAmountInBTC ") var totalFixedAmountInBTC : String = "",
		@ApiModelProperty("Total fixed amount in usdt.") @JsonProperty("totalFixedAmountInUSDT ") var totalFixedAmountInUSDT : String = "",
		@ApiModelProperty("Total flexible in btc.") @JsonProperty("totalFlexibleInBTC ") var totalFlexibleInBTC : String = "",
		@ApiModelProperty("Total flexible in usdt.") @JsonProperty("totalFlexibleInUSDT ") var totalFlexibleInUSDT : String = "") {
}
