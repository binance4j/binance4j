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
var asset:String?=null,
@ApiModelProperty("Borrowed quantity.")
var borrowed:String?=null,
@ApiModelProperty("Free quantity.")
var free:String?=null,
@ApiModelProperty("Loan interest.")
var interest:String?=null,
@ApiModelProperty("Locked quantity.")
var locked:String?=null,
@ApiModelProperty("Net asset quantity.")
var netAsset:String?=null,
@ApiModelProperty("Net asset of Bitcoin.")
var netAssetOfBtc:String?=null,
@ApiModelProperty("Asset total quantity.")
var totalAsset:String?=null,
@ApiModelProperty("Can the account borrow this asset?")
var borrowEnabled:Boolean?=null,
@ApiModelProperty("Can the account repay this asset?") var repayEnabled:Boolean?=null)
{
}