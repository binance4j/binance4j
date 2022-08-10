package com.binance4j.spot.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.spot.client.SpotClient;
import com.binance4j.spot.dto.OrderCount;

import retrofit2.Call;

/** {@link SpotClient#getOrderCount} request. */
@GetRequest(path = "/api/v3/rateLimit/order", signature = Signature.USER_DATA, weight = 20)
public class GetOrderCountRequest extends Request<List<OrderCount>> {
	/**
	 * @param call the retrofit call
	 */
	public GetOrderCountRequest(Call<List<OrderCount>> call) {
		super(call);
	}
}
