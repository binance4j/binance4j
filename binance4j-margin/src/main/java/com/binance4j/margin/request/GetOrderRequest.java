package com.binance4j.margin.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.OrderInfo;

import retrofit2.Call;

/** {@link MarginClient#getOrder} request. */
@GetRequest(path = "/sapi/v1/margin/order", signature = Signature.USER_DATA, weight = 10)
public class GetOrderRequest extends Request<OrderInfo> {
	/**
	 * @param call the retrofit call
	 */
	public GetOrderRequest(Call<OrderInfo> call) {
		super(call);
	}
}
