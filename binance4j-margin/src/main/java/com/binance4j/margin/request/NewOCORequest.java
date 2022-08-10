package com.binance4j.margin.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.PostRequest;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.dto.Signature;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.NewOCOOrderRecord;

import retrofit2.Call;

/** {@link MarginClient#newOCO} request. */
@PostRequest(path = "/sapi/v1/margin/order/oco", rateLimit = RateLimitType.UID, signature = Signature.TRADE, weight = 6)
public class NewOCORequest extends Request<NewOCOOrderRecord> {
	/**
	 * @param call the retrofit call
	 */
	public NewOCORequest(Call<NewOCOOrderRecord> call) {
		super(call);
	}
}
