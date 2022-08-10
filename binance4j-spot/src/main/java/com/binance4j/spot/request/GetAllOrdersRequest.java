package com.binance4j.spot.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.spot.client.SpotClient;
import com.binance4j.spot.dto.OrderInfo;

import retrofit2.Call;

/** {@link SpotClient#getAllOrders} request. */
@GetRequest(path = "/api/v3/allOrders", signature = Signature.USER_DATA, weight = 10)
public class GetAllOrdersRequest extends Request<List<OrderInfo>> {
	/**
	 * @param call the retrofit call
	 */
	public GetAllOrdersRequest(Call<List<OrderInfo>> call) {
		super(call);
	}
}
