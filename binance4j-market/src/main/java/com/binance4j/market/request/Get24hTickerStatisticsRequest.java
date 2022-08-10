package com.binance4j.market.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.market.client.MarketClient;
import com.binance4j.market.dto.TickerStatistics;

import retrofit2.Call;

/** {@link MarketClient#get24hTickerStatistics} request. */
@GetRequest(path = "/api/v3/ticker/24hr")
public class Get24hTickerStatisticsRequest extends Request<TickerStatistics> {
	/**
	 * @param call the retrofit call
	 */
	public Get24hTickerStatisticsRequest(Call<TickerStatistics> call) {
		super(call);
	}
}
