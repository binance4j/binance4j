package com.binance4j.savings.dto;

import com.binance4j.savings.client.SavingsClient;

/**
 * The {@link SavingsClient#fixedToDailyPosition} response.
 * 
 * @param dailyPurchaseId Daily purchase id.
 * @param success         Success.
 * @param time            Time.
 */
public record PositionChangedResponse(long dailyPurchaseId, boolean success, long time) {
}