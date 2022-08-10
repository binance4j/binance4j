package com.binance4j.market.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.market.client.MarketClient;
import com.binance4j.market.dto.Trade;

import retrofit2.Call;

/** {@link MarketClient#getTrades} request. */
@GetRequest(path = "/api/v3/trades")
public class GetTradesRequest extends Request<List<Trade>> {
	/**
	 * @param call the retrofit call
	 */
	public GetTradesRequest(Call<List<Trade>> call) {
		super(call);
	}
}
