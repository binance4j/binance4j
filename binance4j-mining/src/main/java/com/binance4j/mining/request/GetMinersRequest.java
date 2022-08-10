package com.binance4j.mining.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.mining.client.MiningClient;
import com.binance4j.mining.dto.WorkersResponse;

import retrofit2.Call;

/** {@link MiningClient#getMiners} request. */
@GetRequest(path = "/sapi/v1/mining/worker/list", signature = Signature.USER_DATA, weight = 5)
public class GetMinersRequest extends Request<WorkersResponse> {
	/**
	 * @param call the retrofit call
	 */
	public GetMinersRequest(Call<WorkersResponse> call) {
		super(call);
	}
}
