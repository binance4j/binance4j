package com.binance4j.spot.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.spot.client.SpotClient;
import com.binance4j.spot.dto.OCOInfo;

import retrofit2.Call;

/** {@link SpotClient#getAllOCO} request. */
@GetRequest(path = "/api/v3/allOrderList", signature = Signature.USER_DATA, weight = 10)
public class GetAllOCORequest extends Request<List<OCOInfo>> {
	/**
	 * @param call the retrofit call
	 */
	public GetAllOCORequest(Call<List<OCOInfo>> call) {
		super(call);
	}
}
