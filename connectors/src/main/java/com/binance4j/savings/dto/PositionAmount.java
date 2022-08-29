package com.binance4j.savings.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Position Amount.
 * 
 * @property amount       Amount.
 * @property amountInBTC  Amount in BTC.
 * @property amountInUSDT Amount in USDT.
 * @property asset        Asset.
 */
@ApiModel("Position Amount.")
data class PositionAmount(
@ApiModelProperty("Amount.")
@JsonProperty("amount") var amount: String = "",
@ApiModelProperty("Amount in BTC.")
@JsonProperty("amountInBTC") var amountInBTC: String = "",
@ApiModelProperty("Amount in USDT.")
@JsonProperty("amountInUSDT") var amountInUSDT: String = "",
@ApiModelProperty("Asset.")
@JsonProperty("asset") var asset: String = "")
{
}
