package com.binance4j.margin.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.PostRequest;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.dto.Signature;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.NewOrderRecord;

import retrofit2.Call;

/** {@link MarginClient#newOrder} request. */
@PostRequest(path = "/sapi/v1/margin/order", rateLimit = RateLimitType.UID, signature = Signature.TRADE, weight = 6)
public class NewOrderRequest extends Request<NewOrderRecord> {
	/**
	 * @param call the retrofit call
	 */
	public NewOrderRequest(Call<NewOrderRecord> call) {
		super(call);
	}
}
