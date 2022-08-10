package com.binance4j.spot.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.PostRequest;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.dto.Signature;
import com.binance4j.spot.client.SpotClient;
import com.binance4j.spot.dto.NewOrderResponse;

import retrofit2.Call;

/** {@link SpotClient#newOrder} request. */
@PostRequest(path = "/api/v3/order", rateLimit = RateLimitType.UID_AND_IP, signature = Signature.TRADE)
public class NewOrderRequest extends Request<NewOrderResponse> {
	/**
	 * @param call the retrofit call
	 */
	public NewOrderRequest(Call<NewOrderResponse> call) {
		super(call);
	}
}
