package com.binance4j.margin.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.PostRequest;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.dto.Signature;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.BNBBurnStatus;

import retrofit2.Call;

/** {@link MarginClient#borrow} request. */
@PostRequest(path = "/sapi/v1/bnbBurn", rateLimit = RateLimitType.IP, signature = Signature.USER_DATA, weight = 1)
public class ToggleBNBRequest extends Request<BNBBurnStatus> {
	/**
	 * @param call the retrofit call
	 */
	public ToggleBNBRequest(Call<BNBBurnStatus> call) {
		super(call);
	}
}
