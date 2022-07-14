package com.binance4j.spot;

import com.binance4j.core.market.CandlestickInterval;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.vision.spot.VisionSpotClient;

import lombok.Getter;

/** TODO JAVADOC */
public class SpotTest extends ConcurrentTest<VisionSpotClient> {
	public SpotTest() {
		super(new VisionSpotClient());
	}

	@Getter
	protected final String year = "2022";
	@Getter
	protected final String month = "01";
	@Getter
	protected final String day = "01";
	@Getter
	protected final CandlestickInterval interval = CandlestickInterval.ONE_MINUTE;
}
