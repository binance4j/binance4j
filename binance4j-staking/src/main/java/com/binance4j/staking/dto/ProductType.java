package com.binance4j.staking.dto;

import io.swagger.annotations.ApiModelProperty;

/** The product type to get a staking product list. */
public enum ProductType {
	/** Locked staking. */
	STAKING, @ApiModelProperty("")
	/** Flexible DeFi staking. */
	F_DEFI, @ApiModelProperty("")
	/** Locked DeFi staking. */
	L_DEFI
}
