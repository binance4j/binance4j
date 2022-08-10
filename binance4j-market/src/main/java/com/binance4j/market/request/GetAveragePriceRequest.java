package com.binance4j.market.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.market.client.MarketClient;
import com.binance4j.market.dto.AveragePrice;

import retrofit2.Call;

/** {@link MarketClient#getAveragePrice} request. */
@GetRequest(path = "/api/v3/avgPrice")
public class GetAveragePriceRequest extends Request<AveragePrice> {
	/**
	 * @param call the retrofit call
	 */
	public GetAveragePriceRequest(Call<AveragePrice> call) {
		super(call);
	}
}
