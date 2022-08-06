package com.binance4j.margin.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Cross margin fee data collection with any vip level or user's current specific data as
 * <a href="https://www.binance.com/en/margin-fee">here</a>
 * 
 * @param vipLevel        User's VIP level.
 * @param coin            Coin name.
 * @param borrowLimit     Borrow limit.
 * @param dailyInterest   Daily interest.
 * @param yearlyInterest  Yearly interest.
 * @param borrowable      Is it borrowable?
 * @param transferIn      Is internal transfer allowed?
 * @param marginablePairs Bound pairs.
 */
@ApiModel("Cross margin fee data collection")
public record CrossFee(@ApiModelProperty("User's VIP level.") int vipLevel, @ApiModelProperty("Coin name.") String coin,
		@ApiModelProperty("Borrow limit.") String borrowLimit, @ApiModelProperty("Daily interest.") String dailyInterest,
		@ApiModelProperty("Yearly interest.") String yearlyInterest, @ApiModelProperty("Is it borrowable?") boolean borrowable,
		@ApiModelProperty("Is internal transfer allowed?") boolean transferIn, @ApiModelProperty("Bound pairs.") List<String> marginablePairs) {
}