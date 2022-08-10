package com.binance4j.spot.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.spot.client.SpotClient;
import com.binance4j.spot.dto.OrderInfo;

import retrofit2.Call;

/** {@link SpotClient#getOrderStatus} request. */
@GetRequest(path = "/api/v3/order", signature = Signature.USER_DATA, weight = 2)
public class GetOrderStatusRequest extends Request<OrderInfo> {
	/**
	 * @param call the retrofit call
	 */
	public GetOrderStatusRequest(Call<OrderInfo> call) {
		super(call);
	}
}
