package com.binance4j.market.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.market.client.MarketClient;
import com.binance4j.market.dto.ServerTimeResponse;

import retrofit2.Call;

/** {@link MarketClient#getServerTime} request. */
@GetRequest(path = "/api/v3/time")
public class GetServerTimeRequest extends Request<ServerTimeResponse> {
	/**
	 * @param call the retrofit call
	 */
	public GetServerTimeRequest(Call<ServerTimeResponse> call) {
		super(call);
	}
}
