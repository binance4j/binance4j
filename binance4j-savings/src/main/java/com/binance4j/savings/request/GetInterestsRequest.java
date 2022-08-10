package com.binance4j.savings.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.savings.client.SavingsClient;
import com.binance4j.savings.dto.Interest;

import retrofit2.Call;

/** {@link SavingsClient#getInterests} request. */
@GetRequest(path = "/sapi/v1/lending/union/interestHistory", signature = Signature.USER_DATA)
public class GetInterestsRequest extends Request<List<Interest>> {
	/**
	 * @param call the retrofit call
	 */
	public GetInterestsRequest(Call<List<Interest>> call) {
		super(call);
	}
}
