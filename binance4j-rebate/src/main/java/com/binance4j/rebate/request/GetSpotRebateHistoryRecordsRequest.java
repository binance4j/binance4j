package com.binance4j.rebate.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.dto.Signature;
import com.binance4j.rebate.client.RebateClient;
import com.binance4j.rebate.dto.SpotRebateHistoryResponse;

import retrofit2.Call;

/** {@link RebateClient#getSpotRebateHistoryRecords} request. */
@GetRequest(path = "/sapi/v1/rebate/taxQuery", signature = Signature.USER_DATA, rateLimit = RateLimitType.UID, weight = 3000)
public class GetSpotRebateHistoryRecordsRequest extends Request<SpotRebateHistoryResponse> {
	/**
	 * @param call the retrofit call
	 */
	public GetSpotRebateHistoryRecordsRequest(Call<SpotRebateHistoryResponse> call) {
		super(call);
	}
}
