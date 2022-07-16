package com.binance4j.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** The OCO order status. */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum OCOOrderStatus {
    /** ??? */
    EXECUTING,
    /** ??? */
    ALL_DONE,
    /** ??? */
    REJECT
}
