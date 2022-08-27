package com.binance4j.blvt.dto

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * [Token] Basket.
 * @property symbol        Symbol.
 * @property amount        Amount.
 * @property notionalValue Notional value.
 */
@ApiModel("Token Basket.")
data class Basket(
    @ApiModelProperty("Symbol.")
    var symbol: String? = null,
    @ApiModelProperty("Amount.")
    var amount: String? = null,
    @ApiModelProperty("Notional value.")
    var notionalValue: String? = null
)