package com.binance4j.blvt.request;

import com.binance4j.blvt.client.BLVTClient;
import com.binance4j.blvt.dto.SubscriptionResponse;
import com.binance4j.core.Request;
import com.binance4j.core.annotation.PostRequest;
import com.binance4j.core.dto.Signature;

import retrofit2.Call;

/** {@link BLVTClient#subscribe} request. */
@PostRequest(path = "/sapi/v1/blvt/subscribe", isOrder = false, signature = Signature.USER_DATA, weight = 1)
public class SubscribeRequest extends Request<SubscriptionResponse> {
	/**
	 * @param call the retrofit call
	 */
	public SubscribeRequest(Call<SubscriptionResponse> call) {
		super(call);
	}
}
