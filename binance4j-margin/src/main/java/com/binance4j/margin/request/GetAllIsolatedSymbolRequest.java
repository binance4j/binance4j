package com.binance4j.margin.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.IsolatedSymbol;

import retrofit2.Call;

/** {@link MarginClient#getAllIsolatedSymbols} request. */
@GetRequest(path = "/sapi/v1/margin/isolated/allPairs", signature = Signature.USER_DATA, weight = 10)
public class GetAllIsolatedSymbolRequest extends Request<List<IsolatedSymbol>> {
	/**
	 * @param call the retrofit call
	 */
	public GetAllIsolatedSymbolRequest(Call<List<IsolatedSymbol>> call) {
		super(call);
	}
}
