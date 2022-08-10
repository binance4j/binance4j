package com.binance4j.savings.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.PostRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.savings.client.SavingsClient;
import com.binance4j.savings.dto.PurchaseResponse;

import retrofit2.Call;

/** {@link SavingsClient#purchaseFlexible} request. */
@PostRequest(path = "/sapi/v1/lending/daily/purchase", signature = Signature.USER_DATA)
public class PurchaseFlexibleRequest extends Request<PurchaseResponse> {
	/**
	 * @param call the retrofit call
	 */
	public PurchaseFlexibleRequest(Call<PurchaseResponse> call) {
		super(call);
	}
}
