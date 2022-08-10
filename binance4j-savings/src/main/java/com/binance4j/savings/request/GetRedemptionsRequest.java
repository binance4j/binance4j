package com.binance4j.savings.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.savings.client.SavingsClient;
import com.binance4j.savings.dto.Redemption;

import retrofit2.Call;

/** {@link SavingsClient#getRedemptions} request. */
@GetRequest(path = "/sapi/v1/lending/union/redemptionRecord", signature = Signature.USER_DATA)
public class GetRedemptionsRequest extends Request<List<Redemption>> {
	/**
	 * @param call the retrofit call
	 */
	public GetRedemptionsRequest(Call<List<Redemption>> call) {
		super(call);
	}
}
