package com.binance4j.staking.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.staking.client.StakingClient;
import com.binance4j.staking.dto.StakingRecord;

import retrofit2.Call;

/** {@link StakingClient#getHistory} request. */
@GetRequest(path = "/sapi/v1/staking/stakingRecord", signature = Signature.USER_DATA)
public class GetHistoryRequest extends Request<List<StakingRecord>> {
	/**
	 * @param call the retrofit call
	 */
	public GetHistoryRequest(Call<List<StakingRecord>> call) {
		super(call);
	}
}
