package com.binance4j.staking.dto;

/**
 * A staking purchase response.
 * 
 * @param positionId Position id.
 * @param success    Success.
 */
public record PurchaseResponse(String positionId, boolean success) {
}