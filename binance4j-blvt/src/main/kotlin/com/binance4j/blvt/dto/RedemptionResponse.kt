package com.binance4j.blvt.dto

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * BLVT redemption response.
 *
 * @property id           Subscription id.
 * @property status       Subscription status. S("success"), P("pending"), and F("failure").
 * @property tokenName    Token name.
 * @property amount       Redemption value in usdt.
 * @property redeemAmount Redemption token amount.
 * @property timestamp    Timestamp in ms.
 */
@ApiModel("BLVT redemption response.")
data class RedemptionResponse(
    @ApiModelProperty("Subscription id.")
    var id: Long? = null,
    @ApiModelProperty("Subscription status. S(\"success\"), P(\"pending\"), and F(\"failure\").")
    var status: String? = null,
    @ApiModelProperty("Token name.")
    var tokenName: String? = null,
    @ApiModelProperty("Redemption value in usdt.")
    var redeemAmount: String? = null,
    @ApiModelProperty("Redemption token amount.")
    var amount: String? = null,
    @ApiModelProperty("Timestamp in ms.")
    var timestamp: Long? = null
)