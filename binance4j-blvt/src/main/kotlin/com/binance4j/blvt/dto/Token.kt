package com.binance4j.blvt.dto

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * Binance leverage token.
 *
 * @property tokenName          Token name.
 * @property description        Description.
 * @property underlying         Underlying.
 * @property tokenIssued        Token issued.
 * @property basket             Basket.
 * @property currentBaskets     Current baskets.
 * @property nav                Nav.
 * @property realLeverage       Real leverage.
 * @property fundingRate        Funding rate.
 * @property dailyManagementFee Daily management fee.
 * @property purchaseFeePct     Purchase Fee Pct.
 * @property dailyPurchaseLimit Daily Purchase Limit.
 * @property redeemFeePct       Redeem Fee Pct.
 * @property dailyRedeemLimit   Daily Redeem Limit.
 * @property timestamp          Timestamp.
 */
@ApiModel("Binance leverage token.")
data class Token(
    @ApiModelProperty("Token name.") var tokenName: String? = null,
    @ApiModelProperty("Description.") var description: String? = null,
    @ApiModelProperty("Underlying.") var underlying: String? = null,
    @ApiModelProperty("Token issued.") var tokenIssued: String? = null,
    @ApiModelProperty("Basket.") var basket: String? = null,
    @ApiModelProperty("Current baskets.") var currentBaskets: List<Basket>? = null,
    @ApiModelProperty("Nav.") var nav: String? = null,
    @ApiModelProperty("Real leverage.") var realLeverage: String? = null,
    @ApiModelProperty("Funding rate.") var fundingRate: String? = null,
    @ApiModelProperty("Daily management fee.") var dailyManagementFee: String? = null,
    @ApiModelProperty("Purchase Fee Pct.") var purchaseFeePct: String? = null,
    @ApiModelProperty("Daily Purchase Limit.") var dailyPurchaseLimit: String? = null,
    @ApiModelProperty("Redeem Fee Pct.") var redeemFeePct: String? = null,
    @ApiModelProperty("Daily Redeem Limit.") var dailyRedeemLimit: String? = null,
    @ApiModelProperty("Timestamp.") var timestamp: Long? = null
)
