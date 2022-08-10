package com.binance4j.margin.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.IsolatedAccountLimit;

import retrofit2.Call;

/** {@link MarginClient#getEnabledIsolatedAccountLimit} request. */
@GetRequest(path = "/sapi/v1/margin/isolated/accountLimit", signature = Signature.USER_DATA, weight = 1)
public class GetEnabledIsolatedAccountLimitRequest extends Request<IsolatedAccountLimit> {
	/**
	 * @param call the retrofit call
	 */
	public GetEnabledIsolatedAccountLimitRequest(Call<IsolatedAccountLimit> call) {
		super(call);
	}
}
