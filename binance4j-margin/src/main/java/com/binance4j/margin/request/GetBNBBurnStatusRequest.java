package com.binance4j.margin.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.BNBBurnStatus;

import retrofit2.Call;

/** {@link MarginClient#getOrder} request. */
@GetRequest(path = "/sapi/v1/bnbBurn", signature = Signature.USER_DATA)
public class GetBNBBurnStatusRequest extends Request<BNBBurnStatus> {
	/**
	 * @param call the retrofit call
	 */
	public GetBNBBurnStatusRequest(Call<BNBBurnStatus> call) {
		super(call);
	}
}
