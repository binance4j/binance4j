package com.binance4j.savings.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.savings.client.SavingsClient;
import com.binance4j.savings.dto.RedemptionQuota;

import retrofit2.Call;

/** {@link SavingsClient#getLeftDailyRedemptionQuota} request. */
@GetRequest(path = "getLeftDailyRedemptionQuota", signature = Signature.USER_DATA)
public class GetLeftDailyRedemptionQuotaRequest extends Request<RedemptionQuota> {
	/**
	 * @param call the retrofit call
	 */
	public GetLeftDailyRedemptionQuotaRequest(Call<RedemptionQuota> call) {
		super(call);
	}
}
