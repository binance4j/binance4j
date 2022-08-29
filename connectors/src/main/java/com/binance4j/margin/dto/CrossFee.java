package com.binance4j.margin.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Cross margin fee data collection with any vip level or user's current
 * specific data as
 * <a href="https://www.binance.com/en/margin-fee">here</a>
 * 
 * @property vipLevel        User's VIP level.
 * @property coin            Coin name.
 * @property borrowLimit     Borrow limit.
 * @property dailyInterest   Daily interest.
 * @property yearlyInterest  Yearly interest.
 * @property borrowable      Is it borrowable?
 * @property transferIn      Is internal transfer allowed?
 * @property marginablePairs Bound pairs.
 */
@ApiModel("Cross margin fee data collection")
data class CrossFee(@ApiModelProperty("User's VIP level.") int vipLevel, @ApiModelProperty("Coin name.") @JsonProperty("coin ") var coin : String = "",
		@ApiModelProperty("Borrow limit.") @JsonProperty("borrowLimit ") var borrowLimit : String = "",
		@ApiModelProperty("Daily interest.") @JsonProperty("dailyInterest ") var dailyInterest : String = "",
		@ApiModelProperty("Yearly interest.") @JsonProperty("yearlyInterest ") var yearlyInterest : String = "",
		@ApiModelProperty("Is it borrowable?") @JsonProperty("borrowable ") var borrowable : Boolean = false,
		@ApiModelProperty("Is internal transfer allowed?") @JsonProperty("transferIn ") var transferIn : Boolean = false,
		@ApiModelProperty("Bound pairs.") List<String> marginablePairs) {
}