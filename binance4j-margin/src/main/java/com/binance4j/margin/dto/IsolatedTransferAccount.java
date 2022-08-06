package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModelProperty;

/** The account the transfer is made from/to */
public enum IsolatedTransferAccount {
	/** Spot */
	SPOT, @ApiModelProperty("")
	/** Isolated margin */
	ISOLATED_MARGIN
}