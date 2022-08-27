package com.binance4j.blvt.dto

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * A BLVT subscription.
 *
 * @property id          Id.
 * @property tokenName   Token name.
 * @property amount      Amount.
 * @property nav         Nav.
 * @property fee         Fee.
 * @property totalCharge Total charge.
 * @property timestamp   Timestamp in ms.
 */
@ApiModel("A BLVT subscription.")
data class Subscription(
    @ApiModelProperty("Id.") var id: Long? = null,
    @ApiModelProperty("Token name.") var tokenName: String? = null,
    @ApiModelProperty("Amount.") var amount: String? = null,
    @ApiModelProperty("Nav.") var nav: String? = null,
    @ApiModelProperty("Fee.") var fee: String? = null,
    @ApiModelProperty("Total charge.") var totalCharge: String? = null,
    @ApiModelProperty("Timestamp in ms.") var timestamp: Long? = null
)