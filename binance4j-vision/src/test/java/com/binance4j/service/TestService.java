package com.binance4j.service;

import com.binance4j.core.market.CandlestickInterval;
import com.binance4j.core.test.BaseTestService;
import com.binance4j.vision.spot.VisionSpotClient;

public class TestService extends BaseTestService {
	public static final VisionSpotClient CLIENT = new VisionSpotClient();
	public static final String YEAR = "2022";
	public static final String MONTH = "01";
	public static final String DAY = "01";
	public static final CandlestickInterval INTERVAL = CandlestickInterval.ONE_MINUTE;
}
