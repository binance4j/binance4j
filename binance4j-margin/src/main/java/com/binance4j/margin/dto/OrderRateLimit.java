package com.binance4j.margin.dto;

/**
 * margin Order rate limit
 * 
 * @param rateLimitType
 * @param interval
 * @param intervalNum
 * @param limit
 * @param count
 */
public record OrderRateLimit(String rateLimitType, String interval, int intervalNum, int limit, int count) {

}
