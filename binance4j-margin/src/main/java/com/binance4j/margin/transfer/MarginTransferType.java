package com.binance4j.margin.transfer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum MarginTransferType {
    MAIN_TO_MARGIN(1), MARGIN_TO_MAIN(2);

    private int value;

    private MarginTransferType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
