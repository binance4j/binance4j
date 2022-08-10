package com.binance4j.spot.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.spot.client.SpotClient;
import com.binance4j.spot.dto.OrderInfo;

import retrofit2.Call;

/** {@link SpotClient#getOpenOrders} request. */
@GetRequest(path = "/api/v3/openOrders", signature = Signature.USER_DATA, weight = 40)
public class GetOpenOrdersRequest extends Request<List<OrderInfo>> {
	/**
	 * @param call the retrofit call
	 */
	public GetOpenOrdersRequest(Call<List<OrderInfo>> call) {
		super(call);
	}
}
