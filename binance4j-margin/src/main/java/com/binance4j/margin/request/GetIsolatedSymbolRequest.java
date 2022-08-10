package com.binance4j.margin.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.IsolatedSymbol;

import retrofit2.Call;

/** {@link MarginClient#getIsolatedSymbol} request. */
@GetRequest(path = "/sapi/v1/margin/isolated/pair", signature = Signature.USER_DATA, weight = 10)
public class GetIsolatedSymbolRequest extends Request<IsolatedSymbol> {
	/**
	 * @param call the retrofit call
	 */
	public GetIsolatedSymbolRequest(Call<IsolatedSymbol> call) {
		super(call);
	}
}
