package com.binance4j.mining.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.mining.client.MiningClient;
import com.binance4j.mining.dto.HashrateResaleListResponse;

import retrofit2.Call;

/** {@link MiningClient#getHashrateResales} request. */
@GetRequest(path = "/sapi/v1/mining/hash-transfer/config/details/list", signature = Signature.USER_DATA, weight = 5)
public class GetHashrateResalesRequest extends Request<HashrateResaleListResponse> {
	/**
	 * @param call the retrofit call
	 */
	public GetHashrateResalesRequest(Call<HashrateResaleListResponse> call) {
		super(call);
	}
}
