package com.binance4j.spot;

import com.binance4j.core.dto.CandlestickInterval;
import com.binance4j.core.test.CustomTest;
import com.binance4j.vision.client.VisionSpotClient;

import lombok.Getter;

public class SpotTest extends CustomTest<VisionSpotClient> {
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
