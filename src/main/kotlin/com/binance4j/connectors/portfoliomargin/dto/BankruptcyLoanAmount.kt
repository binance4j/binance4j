package com.binance4j.connectors.portfoliomargin.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * Portfolio margin bankruptcy loan amount.
 *
 * @property asset Asset.
 * @property amount Portfolio margin bankruptcy loan amount in BUSD.
 */
@ApiModel("Portfolio margin bankruptcy loan amount.")
data class BankruptcyLoanAmount(
    @ApiModelProperty("Asset.")
    @JsonProperty("asset")
    var asset: String,
    @ApiModelProperty("Portfolio margin bankruptcy loan amount in BUSD.")
    @JsonProperty("amount")
    var amount: String
)