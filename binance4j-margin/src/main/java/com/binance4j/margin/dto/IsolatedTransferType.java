package com.binance4j.margin.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum IsolatedTransferType {
	SPOT, ISOLATED_MARGIN
}
