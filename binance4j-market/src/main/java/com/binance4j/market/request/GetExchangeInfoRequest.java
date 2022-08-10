package com.binance4j.market.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.market.client.MarketClient;
import com.binance4j.market.dto.ExchangeInfo;

import retrofit2.Call;

/** {@link MarketClient#getExchangeInfo} request. */
@GetRequest(path = "/api/v3/exchangeInfo", weight = 10)
public class GetExchangeInfoRequest extends Request<ExchangeInfo> {
	/**
	 * @param call the retrofit call
	 */
	public GetExchangeInfoRequest(Call<ExchangeInfo> call) {
		super(call);
	}
}
