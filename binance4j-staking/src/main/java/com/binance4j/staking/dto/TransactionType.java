package com.binance4j.staking.dto;

import io.swagger.annotations.ApiModelProperty;

/** Transaction type. */
public enum TransactionType {
	/** Subscription. */
	SUBSCRIPTION, @ApiModelProperty("")
	/** Redemption. */
	REDEMPTION, @ApiModelProperty("")
	/** Interest. */
	INTEREST
}
