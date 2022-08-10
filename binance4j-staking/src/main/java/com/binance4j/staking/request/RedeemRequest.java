package com.binance4j.staking.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.PostRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.staking.client.StakingClient;
import com.binance4j.staking.dto.RedeemResponse;

import retrofit2.Call;

/** {@link StakingClient#redeem} request. */
@PostRequest(path = "/sapi/v1/staking/redeem", signature = Signature.USER_DATA)
public class RedeemRequest extends Request<RedeemResponse> {
	/**
	 * @param call the retrofit call
	 */
	public RedeemRequest(Call<RedeemResponse> call) {
		super(call);
	}
}
