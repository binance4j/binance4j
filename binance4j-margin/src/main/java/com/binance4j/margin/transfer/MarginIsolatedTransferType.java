package com.binance4j.margin.transfer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum MarginIsolatedTransferType {
    SPOT, ISOLATED_MARGIN;
}
