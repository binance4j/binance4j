package com.binance4j.margin.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.ApiRequest;
import com.binance4j.core.dto.HttpMethod;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.dto.Signature;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.NewOCOOrderRecord;

import retrofit2.Call;

/** {@link MarginClient#cancelOpenOrders} request. */
@ApiRequest(method = HttpMethod.DELETE, path = "/sapi/v1/margin/orderList", rateLimit = RateLimitType.UID, signature = Signature.TRADE, weight = 1)
public class CancelOCORequest extends Request<NewOCOOrderRecord> {
	/**
	 * @param call the retrofit call
	 */
	public CancelOCORequest(Call<NewOCOOrderRecord> call) {
		super(call);
	}
}
