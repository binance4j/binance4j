package com.binance4j.blvt.dto

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * BLVT subscription response.
 *
 * @property id        Subscription id.
 * @property status    Subscription status. S("success"), P("pending"), and F("failure").
 * @property tokenName Token name.
 * @property amount    Subscribed token amount.
 * @property cost      Subscription cost.
 * @property timestamp Timestamp in ms.
 */
@ApiModel("BLVT subscription response.")
data class SubscriptionResponse(
    @ApiModelProperty("Subscription id.")
    var id: Long? = null,
    @ApiModelProperty("Subscription status. S(\"success\"), P(\"pending\"), and F(\"failure\").")
    var status: String? = null,
    @ApiModelProperty("Token name.")
    var tokenName: String? = null,
    @ApiModelProperty("Subscribed token amount.")
    var amount: String? = null,
    @ApiModelProperty("Subscription cost.")
    var cost: String? = null,
    @ApiModelProperty("Timestamp in ms.")
    var timestamp: Long? = null
)