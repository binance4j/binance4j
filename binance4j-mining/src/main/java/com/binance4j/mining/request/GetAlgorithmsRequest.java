package com.binance4j.mining.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.mining.client.MiningClient;
import com.binance4j.mining.dto.AlgorithmsResponse;

import retrofit2.Call;

/** {@link MiningClient#getAlgorithms} request. */
@GetRequest(path = "/sapi/v1/mining/pub/algoList", signature = Signature.MARKET_DATA)
public class GetAlgorithmsRequest extends Request<AlgorithmsResponse> {
	/**
	 * @param call the retrofit call
	 */
	public GetAlgorithmsRequest(Call<AlgorithmsResponse> call) {
		super(call);
	}
}
