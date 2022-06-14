package com.binance4j.wallet.withdraw;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;

/** A wallet type */
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public enum WalletType {
    SPOT(0), FUNDING(1);

    private final int value;

    public int getValue() {
        return value;
    }
}