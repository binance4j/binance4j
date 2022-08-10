package com.binance4j.staking.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.PostRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.staking.client.StakingClient;
import com.binance4j.staking.dto.PurchaseResponse;

import retrofit2.Call;

/** {@link StakingClient#purchase} request. */
@PostRequest(path = "/sapi/v1/staking/purchase", signature = Signature.USER_DATA)
public class PurchaseRequest extends Request<PurchaseResponse> {
	/**
	 * @param call the retrofit call
	 */
	public PurchaseRequest(Call<PurchaseResponse> call) {
		super(call);
	}
}
