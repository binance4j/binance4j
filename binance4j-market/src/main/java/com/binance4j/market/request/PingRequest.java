package com.binance4j.market.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.market.client.MarketClient;

import retrofit2.Call;

/** {@link MarketClient#ping} request. */
@GetRequest(path = "/api/v3/ping")
public class PingRequest extends Request<Void> {
	/**
	 * @param call the retrofit call
	 */
	public PingRequest(Call<Void> call) {
		super(call);
	}
}
