package com.binance4j.savings.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.savings.client.SavingsClient;
import com.binance4j.savings.dto.FlexibleProductPosition;

import retrofit2.Call;

/** {@link SavingsClient#getFlexibleProductPosition} request. */
@GetRequest(path = "/sapi/v1/lending/daily/token/position", signature = Signature.USER_DATA)
public class GetFlexibleProductPositionRequest extends Request<List<FlexibleProductPosition>> {
	/**
	 * @param call the retrofit call
	 */
	public GetFlexibleProductPositionRequest(Call<List<FlexibleProductPosition>> call) {
		super(call);
	}
}
