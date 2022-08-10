package com.binance4j.margin.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.IsolatedAccount;

import retrofit2.Call;

/** {@link MarginClient#getIsolatedAccount} request. */
@GetRequest(path = "/sapi/v1/margin/isolated/account", signature = Signature.USER_DATA, weight = 10)
public class GetIsolatedAccountRequest extends Request<IsolatedAccount> {
	/**
	 * @param call the retrofit call
	 */
	public GetIsolatedAccountRequest(Call<IsolatedAccount> call) {
		super(call);
	}
}
