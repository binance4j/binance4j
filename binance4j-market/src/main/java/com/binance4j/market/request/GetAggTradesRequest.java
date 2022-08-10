package com.binance4j.market.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.AggTrade;
import com.binance4j.market.client.MarketClient;

import retrofit2.Call;

/** {@link MarketClient#getAggTrades} request. */
@GetRequest(path = "/api/v3/aggTrades")
public class GetAggTradesRequest extends Request<List<AggTrade>> {
	/**
	 * @param call the retrofit call
	 */
	public GetAggTradesRequest(Call<List<AggTrade>> call) {
		super(call);
	}
}
