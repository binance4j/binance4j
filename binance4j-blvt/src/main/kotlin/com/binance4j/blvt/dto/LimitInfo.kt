package com.binance4j.blvt.dto

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * BLVT User Limit Info.
 *
 * @property tokenName                   Token name.
 * @property userDailyTotalPurchaseLimit User daily total purchase limit in USDT.
 * @property userDailyTotalRedeemLimit   User daily total redeem limit in USDT.
 */
@ApiModel("BLVT User Limit Info.")
data class LimitInfo(
    @ApiModelProperty("Token name.")
    var tokenName: String? = null,
    @ApiModelProperty("User daily total purchase limit in USDT.")
    var userDailyTotalPurchaseLimit: String? = null,
    @ApiModelProperty("User daily total redeem limit in USDT.")
    var userDailyTotalRedeemLimit: String? = null
)
