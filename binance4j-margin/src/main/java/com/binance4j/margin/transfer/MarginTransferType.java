package com.binance4j.margin.transfer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public enum MarginTransferType {
    MAIN_TO_MARGIN(1), MARGIN_TO_MAIN(2);

    @Getter
    private final int value;
}
