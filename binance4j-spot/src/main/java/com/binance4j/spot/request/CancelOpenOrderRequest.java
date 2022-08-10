package com.binance4j.spot.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.ApiRequest;
import com.binance4j.core.dto.HttpMethod;
import com.binance4j.core.dto.Signature;
import com.binance4j.spot.client.SpotClient;
import com.binance4j.spot.dto.CancelOrderResponse;

import retrofit2.Call;

/** {@link SpotClient#cancelOpenOrders} request. */
@ApiRequest(method = HttpMethod.DELETE, path = "/api/v3/openOrders", signature = Signature.TRADE)
public class CancelOpenOrderRequest extends Request<List<CancelOrderResponse>> {
	/**
	 * @param call the retrofit call
	 */
	public CancelOpenOrderRequest(Call<List<CancelOrderResponse>> call) {
		super(call);
	}
}
