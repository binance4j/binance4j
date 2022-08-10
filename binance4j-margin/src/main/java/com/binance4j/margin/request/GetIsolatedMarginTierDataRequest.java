package com.binance4j.margin.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.IsolatedTierData;

import retrofit2.Call;

/** {@link MarginClient#getIsolatedMarginTierData} request. */
@GetRequest(path = "/sapi/v1/margin/isolatedMarginTier", signature = Signature.USER_DATA, weight = 1)
public class GetIsolatedMarginTierDataRequest extends Request<List<IsolatedTierData>> {
	/**
	 * @param call the retrofit call
	 */
	public GetIsolatedMarginTierDataRequest(Call<List<IsolatedTierData>> call) {
		super(call);
	}
}
