package com.binance4j.savings.dto;

/**
 * Lending interest.
 * 
 * @param asset       Asset.
 * @param interest    Interest.
 * @param lendingType LendingType.
 * @param productName ProductName.
 * @param time        Time in ms.
 */
public record Interest(String asset, String interest, String lendingType, String productName, long time) {
}