package com.binance4j.margin.dto;

/**
 * A transfer, borrow or repay transaction.
 * 
 * @param tranId The transaction id.
 */
public record Transaction(String tranId) {
}