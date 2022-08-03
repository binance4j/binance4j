package com.binance4j.margin.dto;

/**
 * A transfer, borrow or repay transaction.
 * 
 * @param tranId    The transaction id.
 * @param clientTag The client tag.
 */
public record Transaction(String tranId, String clientTag) {
}