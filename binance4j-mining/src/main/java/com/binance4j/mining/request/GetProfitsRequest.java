package com.binance4j.mining.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.mining.client.MiningClient;
import com.binance4j.mining.dto.ProfitResponse;

import retrofit2.Call;

/** {@link MiningClient#getProfits} request. */
@GetRequest(path = "/sapi/v1/mining/payment/list", signature = Signature.USER_DATA, weight = 5)
public class GetProfitsRequest extends Request<ProfitResponse> {
	/**
	 * @param call the retrofit call
	 */
	public GetProfitsRequest(Call<ProfitResponse> call) {
		super(call);
	}
}
