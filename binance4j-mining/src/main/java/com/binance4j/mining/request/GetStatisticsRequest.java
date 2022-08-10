package com.binance4j.mining.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.mining.client.MiningClient;
import com.binance4j.mining.dto.StatisticsResponse;

import retrofit2.Call;

/** {@link MiningClient#getStatistics} request. */
@GetRequest(path = "/sapi/v1/mining/statistics/user/status", signature = Signature.USER_DATA, weight = 5)
public class GetStatisticsRequest extends Request<StatisticsResponse> {
	/**
	 * @param call the retrofit call
	 */
	public GetStatisticsRequest(Call<StatisticsResponse> call) {
		super(call);
	}
}
