package com.binance4j.mining.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.mining.client.MiningClient;
import com.binance4j.mining.dto.AccountProfitsResponse;

import retrofit2.Call;

/** {@link MiningClient#getAccountProfits} request. */
@GetRequest(path = "/sapi/v1/mining/payment/uid", signature = Signature.USER_DATA, weight = 5)
public class GetAccountProfitstRequest extends Request<AccountProfitsResponse> {
	/**
	 * @param call the retrofit call
	 */
	public GetAccountProfitstRequest(Call<AccountProfitsResponse> call) {
		super(call);
	}
}
