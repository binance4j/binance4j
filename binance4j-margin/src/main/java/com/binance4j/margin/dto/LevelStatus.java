package com.binance4j.margin.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum LevelStatus {
	EXCESSIVE, NORMAL, MARGIN_CALL, PRE_LIQUIDATION, FORCE_LIQUIDATION
}
