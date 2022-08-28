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
data class CrossFee(@ApiModelProperty("User's VIP level.") int vipLevel, @ApiModelProperty("Coin name.") var coin : String? = null,
		@ApiModelProperty("Borrow limit.") var borrowLimit : String? = null,
		@ApiModelProperty("Daily interest.") var dailyInterest : String? = null,
		@ApiModelProperty("Yearly interest.") var yearlyInterest : String? = null,
		@ApiModelProperty("Is it borrowable?") var borrowable : Boolean? = null,
		@ApiModelProperty("Is internal transfer allowed?") var transferIn : Boolean? = null,
		@ApiModelProperty("Bound pairs.") List<String> marginablePairs) {
}