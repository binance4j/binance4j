package com.binance4j.blvt.request;

import com.binance4j.blvt.client.BLVTClient;
import com.binance4j.blvt.dto.RedemptionResponse;
import com.binance4j.core.Request;
import com.binance4j.core.annotation.PostRequest;
import com.binance4j.core.dto.Signature;

import retrofit2.Call;

/** {@link BLVTClient#redeem} request. */
@PostRequest(path = "/sapi/v1/blvt/redeem", signature = Signature.USER_DATA, isOrder = false)
public class RedeemRequest extends Request<RedemptionResponse> {
	/**
	 * @param call the retrofit call
	 */
	public RedeemRequest(Call<RedemptionResponse> call) {
		super(call);
	}
}
