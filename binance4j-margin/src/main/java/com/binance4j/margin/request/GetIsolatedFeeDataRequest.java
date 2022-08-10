package com.binance4j.margin.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.IsolatedFee;

import retrofit2.Call;

/** {@link MarginClient#getIsolatedFeeData} request. */
@GetRequest(path = "/sapi/v1/margin/isolatedMarginData", signature = Signature.USER_DATA, weight = 10)
public class GetIsolatedFeeDataRequest extends Request<List<IsolatedFee>> {
	/**
	 * @param call the retrofit call
	 */
	public GetIsolatedFeeDataRequest(Call<List<IsolatedFee>> call) {
		super(call);
	}
}
