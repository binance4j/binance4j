package com.binance4j.savings.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.PostRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.savings.client.SavingsClient;
import com.binance4j.savings.dto.PositionChangedResponse;

import retrofit2.Call;

/** {@link SavingsClient#fixedToDailyPosition} request. */
@PostRequest(path = "/sapi/v1/lending/positionChanged", signature = Signature.USER_DATA)
public class PositionChangedRequest extends Request<PositionChangedResponse> {
	/**
	 * @param call the retrofit call
	 */
	public PositionChangedRequest(Call<PositionChangedResponse> call) {
		super(call);
	}
}
