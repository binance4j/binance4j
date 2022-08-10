package com.binance4j.market.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.market.client.MarketClient;
import com.binance4j.market.dto.PriceTicker;

import retrofit2.Call;

/** {@link MarketClient#getTicker} request. */
@GetRequest(path = "/api/v3/ticker/price", weight = 2)
public class GetTickerRequest extends Request<PriceTicker> {
	/**
	 * @param call the retrofit call
	 */
	public GetTickerRequest(Call<PriceTicker> call) {
		super(call);
	}
}
