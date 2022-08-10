package com.binance4j.mining.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.PostRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.mining.client.MiningClient;
import com.binance4j.mining.dto.HashrateResaleCancellationResponse;

import retrofit2.Call;

/** {@link MiningClient#cancelHashrateResaleConfiguration} request. */
@PostRequest(path = "/sapi/v1/mining/hash-transfer/config/cancel", signature = Signature.USER_DATA, weight = 5)
public class CancelHashrateResaleConfigurationRequest extends Request<HashrateResaleCancellationResponse> {
	/**
	 * @param call the retrofit call
	 */
	public CancelHashrateResaleConfigurationRequest(Call<HashrateResaleCancellationResponse> call) {
		super(call);
	}
}
