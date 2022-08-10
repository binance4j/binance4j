package com.binance4j.mining.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.mining.client.MiningClient;
import com.binance4j.mining.dto.MinerDetailsResponse;

import retrofit2.Call;

/** {@link MiningClient#getMinersDetails} request. */
@GetRequest(path = "/sapi/v1/mining/worker/detail", signature = Signature.USER_DATA, weight = 5)
public class GetMinersDetailsRequest extends Request<MinerDetailsResponse> {
	/**
	 * @param call the retrofit call
	 */
	public GetMinersDetailsRequest(Call<MinerDetailsResponse> call) {
		super(call);
	}
}
