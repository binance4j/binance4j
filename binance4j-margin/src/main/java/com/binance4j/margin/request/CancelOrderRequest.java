package com.binance4j.margin.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.ApiRequest;
import com.binance4j.core.dto.HttpMethod;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.dto.Signature;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.CancelOrderResponse;

import retrofit2.Call;

/** {@link MarginClient#cancelOrder} request. */
@ApiRequest(method = HttpMethod.DELETE, path = "/sapi/v1/margin/order", rateLimit = RateLimitType.IP, signature = Signature.TRADE, weight = 10)
public class CancelOrderRequest extends Request<CancelOrderResponse> {
	/**
	 * @param call the retrofit call
	 */
	public CancelOrderRequest(Call<CancelOrderResponse> call) {
		super(call);
	}
}
