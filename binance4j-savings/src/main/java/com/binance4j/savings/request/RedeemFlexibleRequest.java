package com.binance4j.savings.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.PostRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.savings.client.SavingsClient;

import retrofit2.Call;

/** {@link SavingsClient#redeemFlexible} request. */
@PostRequest(path = "/sapi/v1/lending/daily/redeem", signature = Signature.USER_DATA)
public class RedeemFlexibleRequest extends Request<Void> {
	/**
	 * @param call the retrofit call
	 */
	public RedeemFlexibleRequest(Call<Void> call) {
		super(call);
	}
}
