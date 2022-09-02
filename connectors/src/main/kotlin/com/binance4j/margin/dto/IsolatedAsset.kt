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
 val asset : String,
@ApiModelProperty("Borrowed quantity.")
 val borrowed : String,
@ApiModelProperty("Free quantity.")
 val free : String,
@ApiModelProperty("Loan interest.")
 val interest : String,
@ApiModelProperty("Locked quantity.")
 val locked : String,
@ApiModelProperty("Net asset quantity.")
 val netAsset : String,
@ApiModelProperty("Net asset of Bitcoin.")
 val netAssetOfBtc : String,
@ApiModelProperty("Asset total quantity.")
 val totalAsset : String,
@ApiModelProperty("Can the account borrow this asset?")
 val borrowEnabled : Boolean,
@ApiModelProperty("Can the account repay this asset?")  val repayEnabled : Boolean)
{
}