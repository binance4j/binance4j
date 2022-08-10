package com.binance4j.staking.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.PostRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.staking.client.StakingClient;
import com.binance4j.staking.dto.AutoStakingResponse;

import retrofit2.Call;

/** {@link StakingClient#setAutoStaking} request. */
@PostRequest(path = "/sapi/v1/staking/setAutoStaking", signature = Signature.USER_DATA)
public class SetAutoStakingRequest extends Request<AutoStakingResponse> {
	/**
	 * @param call the retrofit call
	 */
	public SetAutoStakingRequest(Call<AutoStakingResponse> call) {
		super(call);
	}
}
