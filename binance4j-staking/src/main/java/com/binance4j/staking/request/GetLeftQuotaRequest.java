package com.binance4j.staking.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.staking.client.StakingClient;
import com.binance4j.staking.dto.LeftQuota;

import retrofit2.Call;

/** {@link StakingClient#getLeftQuota} request. */
@GetRequest(path = "/sapi/v1/staking/personalLeftQuota", signature = Signature.USER_DATA)
public class GetLeftQuotaRequest extends Request<LeftQuota> {
	/**
	 * @param call the retrofit call
	 */
	public GetLeftQuotaRequest(Call<LeftQuota> call) {
		super(call);
	}
}
