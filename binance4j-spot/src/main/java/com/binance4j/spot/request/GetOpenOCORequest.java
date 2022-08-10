package com.binance4j.spot.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.spot.client.SpotClient;
import com.binance4j.spot.dto.OCOInfo;

import retrofit2.Call;

/** {@link SpotClient#getOpenOCO} request. */
@GetRequest(path = "/api/v3/openOrderList", signature = Signature.USER_DATA, weight = 3)
public class GetOpenOCORequest extends Request<List<OCOInfo>> {
	/**
	 * @param call the retrofit call
	 */
	public GetOpenOCORequest(Call<List<OCOInfo>> call) {
		super(call);
	}
}
