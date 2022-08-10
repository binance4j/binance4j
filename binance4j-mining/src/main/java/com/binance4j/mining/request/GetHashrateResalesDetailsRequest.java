package com.binance4j.mining.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.mining.client.MiningClient;
import com.binance4j.mining.dto.HashrateResaleDetailResponse;

import retrofit2.Call;

/** {@link MiningClient#getHashrateResalesDetails} request. */
@GetRequest(path = "/sapi/v1/mining/hash-transfer/profit/details", signature = Signature.USER_DATA, weight = 5)
public class GetHashrateResalesDetailsRequest extends Request<HashrateResaleDetailResponse> {
	/**
	 * @param call the retrofit call
	 */
	public GetHashrateResalesDetailsRequest(Call<HashrateResaleDetailResponse> call) {
		super(call);
	}
}
