package com.binance4j.margin.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.ApiRequest;
import com.binance4j.core.dto.HttpMethod;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.dto.Signature;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.CancelOrderResponse;

import retrofit2.Call;

/** {@link MarginClient#cancelOpenOrders} request. */
@ApiRequest(method = HttpMethod.DELETE, path = "/sapi/v1/margin/openOrders", rateLimit = RateLimitType.IP, signature = Signature.TRADE, weight = 1)
public class CancelOpenOrdersRequest extends Request<List<CancelOrderResponse>> {
	/**
	 * @param call the retrofit call
	 */
	public CancelOpenOrdersRequest(Call<List<CancelOrderResponse>> call) {
		super(call);
	}
}
