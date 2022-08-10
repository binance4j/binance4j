package com.binance4j.margin.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.Account;

import retrofit2.Call;

/** {@link MarginClient#getAccount} request. */
@GetRequest(path = "/sapi/v1/margin/account", signature = Signature.USER_DATA, weight = 10)
public class GetAccountRequest extends Request<Account> {
	/**
	 * @param call the retrofit call
	 */
	public GetAccountRequest(Call<Account> call) {
		super(call);
	}
}
