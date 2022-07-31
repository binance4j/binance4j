package com.binance4j.margin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A transfer, borrow or repay transaction.
 * 
 * @param id The transaction id.
 */
public record Transaction(@JsonProperty("tranId") String id) {
}