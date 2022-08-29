package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An asset on the platform.
 * 
 * @property assetFullName  Asset full name.
 * @property assetName      Asset name.
 * @property userMinBorrow  User minimum borrow.
 * @property userMinRepay   User minimum repay.
 * @property isBorrowable   Is it borrowable?
 * @property isMortgageable Is it mortgageable?
 */
@ApiModel("An asset on the platform.")
data class Asset(
@ApiModelProperty("Asset full name.")
@JsonProperty("assetFullName") var assetFullName: String = "",
@ApiModelProperty("Asset name.")
@JsonProperty("assetName") var assetName: String = "",
@ApiModelProperty("User minimum borrow.")
@JsonProperty("userMinBorrow") var userMinBorrow: String = "",
@ApiModelProperty("User minimum repay.")
@JsonProperty("userMinRepay") var userMinRepay: String = "",
@ApiModelProperty("Is it borrowable?")
@JsonProperty("isBorrowable") var isBorrowable: Boolean = false,
@ApiModelProperty("Is it mortgageable?") @JsonProperty("isMortgageable") var isMortgageable: Boolean = false)
{
}