package com.binance4j.mining.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.mining.client.MiningClient;
import com.binance4j.mining.dto.CoinsResponse;

import retrofit2.Call;

/** {@link MiningClient#getCoins} request. */
@GetRequest(path = "/sapi/v1/mining/pub/coinList", signature = Signature.MARKET_DATA)
public class GetCoinsRequest extends Request<CoinsResponse> {
	/**
	 * @param call the retrofit call
	 */
	public GetCoinsRequest(Call<CoinsResponse> call) {
		super(call);
	}
}
