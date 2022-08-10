package com.binance4j.margin.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.InterestHistory;

import retrofit2.Call;

/** {@link MarginClient#getInterestHistory} request. */
@GetRequest(path = "/sapi/v1/margin/interestHistory", signature = Signature.USER_DATA)
public class GetInterestHistoryRequest extends Request<InterestHistory> {
	/**
	 * @param call the retrofit call
	 */
	public GetInterestHistoryRequest(Call<InterestHistory> call) {
		super(call);
	}
}
