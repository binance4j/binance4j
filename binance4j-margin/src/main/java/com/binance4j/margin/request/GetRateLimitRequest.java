package com.binance4j.margin.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.OrderRateLimit;

import retrofit2.Call;

/** {@link MarginClient#getRateLimit} request. */
@GetRequest(path = "/sapi/v1/margin/rateLimit/order", signature = Signature.TRADE, weight = 20)
public class GetRateLimitRequest extends Request<List<OrderRateLimit>> {
	/**
	 * @param call the retrofit call
	 */
	public GetRateLimitRequest(Call<List<OrderRateLimit>> call) {
		super(call);
	}
}
