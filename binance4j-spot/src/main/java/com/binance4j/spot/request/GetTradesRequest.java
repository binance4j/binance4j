package com.binance4j.spot.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.core.dto.Trade;
import com.binance4j.spot.client.SpotClient;

import retrofit2.Call;

/** {@link SpotClient#getTrades} request. */
@GetRequest(path = "/api/v3/myTrades", signature = Signature.USER_DATA, weight = 10)
public class GetTradesRequest extends Request<List<Trade>> {
	/**
	 * @param call the retrofit call
	 */
	public GetTradesRequest(Call<List<Trade>> call) {
		super(call);
	}
}
