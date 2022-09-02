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
 val assetFullName : String,
@ApiModelProperty("Asset name.")
 val assetName : String,
@ApiModelProperty("User minimum borrow.")
 val userMinBorrow : String,
@ApiModelProperty("User minimum repay.")
 val userMinRepay : String,
@ApiModelProperty("Is it borrowable?")
 val isBorrowable : Boolean,
@ApiModelProperty("Is it mortgageable?")  val isMortgageable : Boolean)
{
}