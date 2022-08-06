package com.binance4j.blvt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * BLVT User Limit Info.
 * 
 * @param tokenName                   Token name.
 * @param userDailyTotalPurchaseLimit User daily total purchase limit in USDT.
 * @param userDailyTotalRedeemLimit   User daily total redeem limit in USDT.
 */
@ApiModel("BLVT User Limit Info.")
public record LimitInfo(@ApiModelProperty("Token name.") String tokenName,
		@ApiModelProperty("User daily total purchase limit in USDT.") String userDailyTotalPurchaseLimit,
		@ApiModelProperty("User daily total redeem limit in USDT.") String userDailyTotalRedeemLimit) {
}
