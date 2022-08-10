package com.binance4j.blvt.request;

import java.util.List;

import com.binance4j.blvt.client.BLVTClient;
import com.binance4j.blvt.dto.Subscription;
import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;

import retrofit2.Call;

/** {@link BLVTClient#getSubscriptions} request. */
@GetRequest(path = "/sapi/v1/blvt/subscribe/record", signature = Signature.USER_DATA)
public class GetSubscriptionsRequest extends Request<List<Subscription>> {
	/**
	 * @param call the retrofit call
	 */
	public GetSubscriptionsRequest(Call<List<Subscription>> call) {
		super(call);
	}
}
