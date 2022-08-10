package com.binance4j.margin.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.ApiRequest;
import com.binance4j.core.dto.HttpMethod;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.dto.Signature;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.ToogleAccountResponse;

import retrofit2.Call;

/** {@link MarginClient#disableIsolatedAccount} request. */
@ApiRequest(method = HttpMethod.DELETE, path = "/sapi/v1/margin/isolated/account", rateLimit = RateLimitType.UID, signature = Signature.TRADE, weight = 300)
public class DisableIsolatedAccountRequest extends Request<ToogleAccountResponse> {
	/**
	 * @param call the retrofit call
	 */
	public DisableIsolatedAccountRequest(Call<ToogleAccountResponse> call) {
		super(call);
	}
}
