package com.binance4j.margin.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** The account the transfer is made from/to */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum IsolatedTransferAccount {
	/** Spot */
	SPOT,
	/** Isolated margin */
	ISOLATED_MARGIN
}