package com.binance4j.spot.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.ApiRequest;
import com.binance4j.core.dto.HttpMethod;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.dto.Signature;
import com.binance4j.spot.client.SpotClient;
import com.binance4j.spot.dto.OCOResponse;

import retrofit2.Call;

/** {@link SpotClient#cancelOrder} request. */
@ApiRequest(method = HttpMethod.DELETE, path = "/api/v3/orderList", rateLimit = RateLimitType.IP, signature = Signature.TRADE)
public class CancelOCORequest extends Request<OCOResponse> {
	/**
	 * @param call the retrofit call
	 */
	public CancelOCORequest(Call<OCOResponse> call) {
		super(call);
	}
}
