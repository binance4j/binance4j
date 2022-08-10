package com.binance4j.market.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Candle;
import com.binance4j.market.client.MarketClient;

import retrofit2.Call;

/** {@link MarketClient#getKlines} request. */
@GetRequest(path = "/api/v3/klines")
public class GetKlinesRequest extends Request<List<Candle>> {
	/**
	 * @param call the retrofit call
	 */
	public GetKlinesRequest(Call<List<Candle>> call) {
		super(call);
	}
}
