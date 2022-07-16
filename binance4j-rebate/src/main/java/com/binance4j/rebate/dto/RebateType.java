package com.binance4j.rebate.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** The rebate type. */
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public enum RebateType {
    COMMISSION_REBATE(1), REFERRAL_KICKBACK(2);

    /** The error code. */
    @Getter
    private final int value;
}
