package com.binance4j.websocket.service;

import java.time.Duration;

import com.binance4j.core.dto.CandlestickInterval;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/** Service for converting data into a duration */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DurationService {
	/**
	 * Converts a candlestick interval into a duration
	 *
	 * @param interval The candlestick interval.
	 * @return The corresponding duration.
	 */
	public static Duration convert(CandlestickInterval interval) {
		return switch (interval) {
		case DAILY -> Duration.ofDays(1);
		case EIGHT_HOURLY -> Duration.ofHours(8);
		case FIFTEEN_MINUTES -> Duration.ofMinutes(15);
		case FIVE_MINUTES -> Duration.ofMinutes(5);
		case FOUR_HOURLY -> Duration.ofHours(4);
		case HALF_HOURLY -> Duration.ofMinutes(30);
		case HOURLY -> Duration.ofHours(1);
		case MONTHLY_MARKET, MONTHLY_VISION -> Duration.ofDays(30);
		case ONE_MINUTE -> Duration.ofMinutes(1);
		case SIX_HOURLY -> Duration.ofHours(6);
		case THREE_DAILY -> Duration.ofDays(3);
		case THREE_MINUTES -> Duration.ofMinutes(3);
		case TWELVE_HOURLY -> Duration.ofHours(12);
		case TWO_HOURLY -> Duration.ofHours(2);
		case WEEKLY -> Duration.ofDays(7);
		default -> null;
		};
	}
}
