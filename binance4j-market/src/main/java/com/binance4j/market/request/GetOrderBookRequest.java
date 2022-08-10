package com.binance4j.market.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.market.client.MarketClient;
import com.binance4j.market.dto.OrderBook;

import retrofit2.Call;

/** {@link MarketClient#getOrderBook} request. */
@GetRequest(path = "/api/v3/depth", weight = 50)
public class GetOrderBookRequest extends Request<OrderBook> {
	/**
	 * @param call the retrofit call
	 */
	public GetOrderBookRequest(Call<OrderBook> call) {
		super(call);
	}
}
