package com.binance4j.connectors.portfoliomargin.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * Repay response.
 *
 * @property tranId Transaction ID.
 */
@ApiModel("Repay response.")
data class RepayResponse(
    @ApiModelProperty("Transaction ID.")
    @JsonProperty("tranId")
    var tranId: String,
)