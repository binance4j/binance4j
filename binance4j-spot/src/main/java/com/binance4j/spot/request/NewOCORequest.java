package com.binance4j.spot.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.PostRequest;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.dto.Signature;
import com.binance4j.spot.client.SpotClient;
import com.binance4j.spot.dto.OCOResponse;

import retrofit2.Call;

/** {@link SpotClient#newOCO} request. */
@PostRequest(path = "/api/v3/order/oco", rateLimit = RateLimitType.UID_AND_IP, signature = Signature.TRADE, weight = 2)
public class NewOCORequest extends Request<OCOResponse> {
	/**
	 * @param call the retrofit call
	 */
	public NewOCORequest(Call<OCOResponse> call) {
		super(call);
	}
}
