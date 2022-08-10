package com.binance4j.market.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.market.client.MarketClient;
import com.binance4j.market.dto.BookTicker;

import retrofit2.Call;

/** {@link MarketClient#getBookTicker} request. */
@GetRequest(path = "/api/v3/ticker/bookTicker", weight = 2)
public class GetBookTickerRequest extends Request<BookTicker> {
	/**
	 * @param call the retrofit call
	 */
	public GetBookTickerRequest(Call<BookTicker> call) {
		super(call);
	}
}
