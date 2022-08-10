package com.binance4j.spot.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.PostRequest;
import com.binance4j.spot.client.SpotClient;

import retrofit2.Call;

/** {@link SpotClient#newOrderTest} request. */
@PostRequest(path = "/api/v3/order/test", weight = 1)
public class NewOrderTestRequest extends Request<Void> {
	/**
	 * @param call the retrofit call
	 */
	public NewOrderTestRequest(Call<Void> call) {
		super(call);
	}
}
