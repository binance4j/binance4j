package com.binance4j.margin.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.OrderInfo;

import retrofit2.Call;

/** {@link MarginClient#getLoanRecord} request. */
@GetRequest(path = "/sapi/v1/margin/allOrders", signature = Signature.USER_DATA, weight = 200)
public class GetAllOrdersRequest extends Request<List<OrderInfo>> {
	/**
	 * @param call the retrofit call
	 */
	public GetAllOrdersRequest(Call<List<OrderInfo>> call) {
		super(call);
	}
}
