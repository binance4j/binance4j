package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModelProperty;

/** The account snapshot type */
public enum AccountSnapshotType {
	/** SPOT. */
	SPOT, @ApiModelProperty("")
	/** MARGIN. */
	MARGIN, @ApiModelProperty("")
	/** FUTURES. */
	FUTURES
}