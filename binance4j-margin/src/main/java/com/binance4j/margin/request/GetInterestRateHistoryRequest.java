package com.binance4j.margin.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.InterestRate;

import retrofit2.Call;

/** {@link MarginClient#getOrder} request. */
@GetRequest(path = "/sapi/v1/margin/interestRateHistory", signature = Signature.USER_DATA, weight = 1)
public class GetInterestRateHistoryRequest extends Request<List<InterestRate>> {
	/**
	 * @param call the retrofit call
	 */
	public GetInterestRateHistoryRequest(Call<List<InterestRate>> call) {
		super(call);
	}
}
