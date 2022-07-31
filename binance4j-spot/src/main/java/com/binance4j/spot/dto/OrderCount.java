package com.binance4j.spot.dto;

/**
 * The user's current order count usage for all intervals.
 * 
 * @param rateLimitType The type of order.
 * @param interval      The order interval.
 * @param intervalNum   The order interval num.
 * @param limit         The order limit.
 * @param count         The current order count.
 */
public record OrderCount(String rateLimitType, String interval, int intervalNum, int limit, int count) {
}