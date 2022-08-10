package com.binance4j.savings.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.savings.client.SavingsClient;
import com.binance4j.savings.dto.LendingAccount;

import retrofit2.Call;

/** {@link SavingsClient#getAccount} request. */
@GetRequest(path = "/sapi/v1/lending/union/account", signature = Signature.USER_DATA)
public class GetAccountRequest extends Request<LendingAccount> {
	/**
	 * @param call the retrofit call
	 */
	public GetAccountRequest(Call<LendingAccount> call) {
		super(call);
	}
}
