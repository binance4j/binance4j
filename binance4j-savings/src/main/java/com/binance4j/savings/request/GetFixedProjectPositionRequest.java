package com.binance4j.savings.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.savings.client.SavingsClient;
import com.binance4j.savings.dto.FixedProjectPosition;

import retrofit2.Call;

/** {@link SavingsClient#getFixedProjectPosition} request. */
@GetRequest(path = "/sapi/v1/lending/project/position/list", signature = Signature.USER_DATA)
public class GetFixedProjectPositionRequest extends Request<List<FixedProjectPosition>> {
	/**
	 * @param call the retrofit call
	 */
	public GetFixedProjectPositionRequest(Call<List<FixedProjectPosition>> call) {
		super(call);
	}
}
