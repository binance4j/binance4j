package com.binance4j.mining.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.PostRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.mining.client.MiningClient;
import com.binance4j.mining.dto.HashrateResaleResponse;

import retrofit2.Call;

/** {@link MiningClient#resellHashrate} request. */
@PostRequest(path = "/sapi/v1/mining/hash-transfer/config", signature = Signature.USER_DATA, weight = 5)
public class ResellHashrateRequest extends Request<HashrateResaleResponse> {
	/**
	 * @param call the retrofit call
	 */
	public ResellHashrateRequest(Call<HashrateResaleResponse> call) {
		super(call);
	}
}
