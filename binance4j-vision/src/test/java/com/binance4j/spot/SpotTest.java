package com.binance4j.spot;

import com.binance4j.core.client.RestClient;
import com.binance4j.core.dto.CandlestickInterval;
import com.binance4j.core.test.CustomTest;
import com.binance4j.vision.client.VisionSpotClient;

public class SpotTest extends CustomTest {
	VisionSpotClient client = new VisionSpotClient();
	protected final String year = "2022";
	protected final String month = "01";
	protected final String day = "01";
	protected final CandlestickInterval interval = CandlestickInterval.ONE_MINUTE;

	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * @return the day
	 */
	public String getDay() {
		return day;
	}

	/**
	 * @return the interval
	 */
	public CandlestickInterval getInterval() {
		return interval;
	}

	@Override
	protected RestClient<?> getClient() {
		return null;
	}
}
