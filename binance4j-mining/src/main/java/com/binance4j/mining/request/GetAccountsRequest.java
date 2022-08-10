package com.binance4j.mining.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.mining.client.MiningClient;
import com.binance4j.mining.dto.AccountListResponse;

import retrofit2.Call;

/** {@link MiningClient#getAccounts} request. */
@GetRequest(path = "/sapi/v1/mining/statistics/user/list", signature = Signature.USER_DATA, weight = 5)
public class GetAccountsRequest extends Request<AccountListResponse> {
	/**
	 * @param call the retrofit call
	 */
	public GetAccountsRequest(Call<AccountListResponse> call) {
		super(call);
	}
}
