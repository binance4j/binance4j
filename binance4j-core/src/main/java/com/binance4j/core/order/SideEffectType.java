package com.binance4j.core.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Desired side-effect for margin orders
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum SideEffectType {
    /** normal trade order */
    NO_SIDE_EFFECT,
    /** margin trade order */
    MARGIN_BUY,
    /** for making auto repayment after order filled */
    AUTO_REPAY
}
