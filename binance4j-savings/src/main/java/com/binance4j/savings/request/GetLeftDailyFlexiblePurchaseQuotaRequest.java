package com.binance4j.savings.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.savings.client.SavingsClient;
import com.binance4j.savings.dto.PurchaseQuota;

import retrofit2.Call;

/** {@link SavingsClient#getLeftDailyFlexiblePurchaseQuota} request. */
@GetRequest(path = "/sapi/v1/lending/daily/userLeftQuota", signature = Signature.USER_DATA)
public class GetLeftDailyFlexiblePurchaseQuotaRequest extends Request<PurchaseQuota> {
	/**
	 * @param call the retrofit call
	 */
	public GetLeftDailyFlexiblePurchaseQuotaRequest(Call<PurchaseQuota> call) {
		super(call);
	}
}
