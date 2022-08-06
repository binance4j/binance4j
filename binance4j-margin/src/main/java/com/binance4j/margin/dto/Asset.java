package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An asset on the platform.
 * 
 * @param assetFullName  Asset full name.
 * @param assetName      Asset name.
 * @param userMinBorrow  User minimum borrow.
 * @param userMinRepay   User minimum repay.
 * @param isBorrowable   Is it borrowable?
 * @param isMortgageable Is it mortgageable?
 */
@ApiModel("An asset on the platform.")
public record Asset(@ApiModelProperty("Asset full name.") String assetFullName, @ApiModelProperty("Asset name.") String assetName,
		@ApiModelProperty("User minimum borrow.") String userMinBorrow, @ApiModelProperty("User minimum repay.") String userMinRepay,
		@ApiModelProperty("Is it borrowable?") boolean isBorrowable, @ApiModelProperty("Is it mortgageable?") boolean isMortgageable) {
}