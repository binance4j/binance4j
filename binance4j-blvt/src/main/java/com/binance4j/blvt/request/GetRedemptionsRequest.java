package com.binance4j.blvt.request;

import java.util.List;

import com.binance4j.blvt.client.BLVTClient;
import com.binance4j.blvt.dto.Redemption;
import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;

import retrofit2.Call;

/** {@link BLVTClient#getRedemptions} request. */
@GetRequest(path = "/sapi/v1/blvt/redeem/record", isOrder = false, signature = Signature.USER_DATA, weight = 1)
public class GetRedemptionsRequest extends Request<List<Redemption>> {
	/**
	 * @param call the retrofit call
	 */
	public GetRedemptionsRequest(Call<List<Redemption>> call) {
		super(call);
	}
}
