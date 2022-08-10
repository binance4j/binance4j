package com.binance4j.margin.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.CrossSymbol;

import retrofit2.Call;

/** {@link MarginClient#getAllCrossMarginPairs} request. */
@GetRequest(path = "/sapi/v1/margin/allAssets", signature = Signature.MARKET_DATA)
public class GetAllCrossMarginPairRequest extends Request<List<CrossSymbol>> {
	/**
	 * @param call the retrofit call
	 */
	public GetAllCrossMarginPairRequest(Call<List<CrossSymbol>> call) {
		super(call);
	}
}
