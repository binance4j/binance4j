package com.binance4j.spot.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.spot.client.SpotClient;
import com.binance4j.spot.dto.OCOInfo;

import retrofit2.Call;

/** {@link SpotClient#getOCO} request. */
@GetRequest(path = "/api/v3/orderList", signature = Signature.USER_DATA, weight = 2)
public class GetOCORequest extends Request<OCOInfo> {
	/**
	 * @param call the retrofit call
	 */
	public GetOCORequest(Call<OCOInfo> call) {
		super(call);
	}
}
