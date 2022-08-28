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
var assetFullName:String?=null,
@ApiModelProperty("Asset name.")
var assetName:String?=null,
@ApiModelProperty("User minimum borrow.")
var userMinBorrow:String?=null,
@ApiModelProperty("User minimum repay.")
var userMinRepay:String?=null,
@ApiModelProperty("Is it borrowable?")
var isBorrowable:Boolean?=null,
@ApiModelProperty("Is it mortgageable?") var isMortgageable:Boolean?=null)
{
}