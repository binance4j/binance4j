package com.binance4j.savings.dto;

import io.swagger.annotations.ApiModelProperty;

/** Transaction type. */
public enum LendingType {
	/** Daily. */
	DAILY, @ApiModelProperty("")
	/** Activity. */
	ACTIVITY, @ApiModelProperty("")
	/** Customized fixed. */
	CUSTOMIZED_FIXED
}
