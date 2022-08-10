package com.binance4j.margin.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.Trade;

import retrofit2.Call;

/** {@link MarginClient#getTrades} request. */
@GetRequest(path = "/sapi/v1/margin/myTrades", signature = Signature.MARKET_DATA, weight = 10)
public class GetTradesRequest extends Request<List<Trade>> {
	/**
	 * @param call the retrofit call
	 */
	public GetTradesRequest(Call<List<Trade>> call) {
		super(call);
	}
}
