package com.binance4j.pay.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.dto.Signature;
import com.binance4j.pay.client.PayClient;
import com.binance4j.pay.dto.TradeHistory;

import retrofit2.Call;

/** {@link PayClient#getTrades} request. */
@GetRequest(path = "/sapi/v1/pay/transactions", signature = Signature.USER_DATA, rateLimit = RateLimitType.UID, weight = 3000)
public class GetTradesRequest extends Request<TradeHistory> {
	/**
	 * @param call the retrofit call
	 */
	public GetTradesRequest(Call<TradeHistory> call) {
		super(call);
	}
}
