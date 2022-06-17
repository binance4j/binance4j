package com.binance4j.margin.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum MarginLevelStatus {
    EXCESSIVE, NORMAL, MARGIN_CALL, PRE_LIQUIDATION, FORCE_LIQUIDATION
}
