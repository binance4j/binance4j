package com.binance4j.staking.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.staking.client.StakingClient;
import com.binance4j.staking.dto.ProductPosition;

import retrofit2.Call;

/** {@link StakingClient#getPosition} request. */
@GetRequest(path = "/sapi/v1/staking/position", signature = Signature.USER_DATA)
public class GetPositionRequest extends Request<List<ProductPosition>> {
	/**
	 * @param call the retrofit call
	 */
	public GetPositionRequest(Call<List<ProductPosition>> call) {
		super(call);
	}
}
