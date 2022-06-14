package com.binance4j.websocket.service;

import java.time.Duration;

import com.binance4j.core.market.CandlestickInterval;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/** Service for converting data into a duration */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DurationService {
    /**
     * Converts a candlestick interval into a duration
     * 
     * @param interval The candlestick interval
     * @return The corresponding duration
     */
    public static Duration convert(CandlestickInterval interval) {
        switch (interval) {
            case DAILY:
                return Duration.ofDays(1);
            case EIGHT_HOURLY:
                return Duration.ofHours(8);
            case FIFTEEN_MINUTES:
                return Duration.ofMinutes(15);
            case FIVE_MINUTES:
                return Duration.ofMinutes(5);
            case FOUR_HOURLY:
                return Duration.ofHours(4);
            case HALF_HOURLY:
                return Duration.ofMinutes(30);
            case HOURLY:
                return Duration.ofHours(1);
            case MONTHLY_MARKET:
                return Duration.ofDays(30);
            case MONTHLY_VISION:
                return Duration.ofDays(30);
            case ONE_MINUTE:
                return Duration.ofMinutes(1);
            case SIX_HOURLY:
                return Duration.ofHours(6);
            case THREE_DAILY:
                return Duration.ofDays(3);
            case THREE_MINUTES:
                return Duration.ofMinutes(3);
            case TWELVE_HOURLY:
                return Duration.ofHours(12);
            case TWO_HOURLY:
                return Duration.ofHours(2);
            case WEEKLY:
                return Duration.ofDays(7);
            default:
                return null;
        }
    }
}
