package com.binance4j.spot.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.spot.client.SpotClient;
import com.binance4j.spot.dto.Account;

import retrofit2.Call;

/** {@link SpotClient#getAccount} request. */
@GetRequest(path = "/api/v3/account", signature = Signature.USER_DATA, weight = 10)
public class GetAccountRequest extends Request<Account> {
	/**
	 * @param call the retrofit call
	 */
	public GetAccountRequest(Call<Account> call) {
		super(call);
	}
}
