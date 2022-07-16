package com.binance4j.margin.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** The margin level status */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum LevelStatus {
	/** Excessive */
	EXCESSIVE,
	/** Normal */
	NORMAL,
	/** Margin call */
	MARGIN_CALL,
	/** Pre liquidation */
	PRE_LIQUIDATION,
	/** Force liquidation */
	FORCE_LIQUIDATION
}
