package com.binance4j.margin.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.CrossSymbol;

import retrofit2.Call;

/** {@link MarginClient#getCrossMarginPair} request. */
@GetRequest(path = "/sapi/v1/margin/pair", signature = Signature.MARKET_DATA, weight = 10)
public class GetCrossMarginPairRequest extends Request<CrossSymbol> {
	/**
	 * @param call the retrofit call
	 */
	public GetCrossMarginPairRequest(Call<CrossSymbol> call) {
		super(call);
	}
}
