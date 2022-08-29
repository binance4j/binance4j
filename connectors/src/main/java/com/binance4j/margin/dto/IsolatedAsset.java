package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Isolated asset in {@link IsolatedPair}.
 * 
 * @property asset         Asset name.
 * @property borrowEnabled Borrowed quantity.
 * @property repayEnabled  Free quantity.
 * @property borrowed      Loan interest.
 * @property free          Locked quantity.
 * @property interest      Net asset quantity.
 * @property locked        Net asset of Bitcoin.
 * @property netAsset      Asset total quantity.
 * @property netAssetOfBtc Can the account borrow this asset?
 * @property totalAsset    Can the account repay this asset?
 */
@ApiModel("Isolated asset in isolated pair.")
data class IsolatedAsset(
@ApiModelProperty("Asset name.")
@JsonProperty("asset") var asset: String = "",
@ApiModelProperty("Borrowed quantity.")
@JsonProperty("borrowed") var borrowed: String = "",
@ApiModelProperty("Free quantity.")
@JsonProperty("free") var free: String = "",
@ApiModelProperty("Loan interest.")
@JsonProperty("interest") var interest: String = "",
@ApiModelProperty("Locked quantity.")
@JsonProperty("locked") var locked: String = "",
@ApiModelProperty("Net asset quantity.")
@JsonProperty("netAsset") var netAsset: String = "",
@ApiModelProperty("Net asset of Bitcoin.")
@JsonProperty("netAssetOfBtc") var netAssetOfBtc: String = "",
@ApiModelProperty("Asset total quantity.")
@JsonProperty("totalAsset") var totalAsset: String = "",
@ApiModelProperty("Can the account borrow this asset?")
@JsonProperty("borrowEnabled") var borrowEnabled: Boolean = false,
@ApiModelProperty("Can the account repay this asset?") @JsonProperty("repayEnabled") var repayEnabled: Boolean = false)
{
}