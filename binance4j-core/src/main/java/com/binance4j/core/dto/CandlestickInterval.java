package com.binance4j.core.dto;

/**
 * Kline/Candlestick intervals. m : minutes; h : hours; d : days; w : weeks; M :
 * months
 */
public enum CandlestickInterval {
	/** 1 minute interval. */
	ONE_MINUTE("1m"),
	/** 3 minutes interval. */
	THREE_MINUTES("3m"),
	/** 5 minutes interval. */
	FIVE_MINUTES("5m"),
	/** 15 minutes interval. */
	FIFTEEN_MINUTES("15m"),
	/** 30 minutes interval. */
	HALF_HOURLY("30m"),
	/** 1 hour interval. */
	HOURLY("1h"),
	/** 2 hours interval. */
	TWO_HOURLY("2h"),
	/** 4 hours interval. */
	FOUR_HOURLY("4h"),
	/** 6 hours interval. */
	SIX_HOURLY("6h"),
	/** 8 hours interval. */
	EIGHT_HOURLY("8h"),
	/** 12 hours interval. */
	TWELVE_HOURLY("12h"),
	/** 1 day interval. */
	DAILY("1d"),
	/** 3 days interval. */
	THREE_DAILY("3d"),
	/** 1 week interval. */
	WEEKLY("1w"),
	/** 1-month interval for market data. */
	MONTHLY_MARKET("1M"),
	/** 1-month interval for vision data. */
	MONTHLY_VISION("1mo");

	/** @param value Value */
	private CandlestickInterval(String value) {
		this.value = value;
	}

	/** The interval id */
	final String value;

	@Override
	public String toString() {
		return value;
	}

	/**
	 * @param value The interval String value.
	 * @return The enum equivalent of the input value.
	 */
	static public CandlestickInterval fromValue(String value) {
		for (CandlestickInterval e : CandlestickInterval.values()) {
			if (e.toString().equals(value)) {
				return e;
			}
		}
		return null;
	}
}