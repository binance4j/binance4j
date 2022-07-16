package com.binance4j.core.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The contingency type. A contingent order is an order that is linked to, and requires, the execution of another event.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum ContingencyType {
    /** One cancels the other */
    OCO
}
