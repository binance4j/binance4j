package com.binance4j.wallet.deposit;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** The coin deposit status */
@AllArgsConstructor
public enum DepositStatus {
    PENDING(0), CANNOT_WITHDRAW(6), SUCCESS(1);

    /**
     * The status number
     */
    @Getter
    private final int value;
}
