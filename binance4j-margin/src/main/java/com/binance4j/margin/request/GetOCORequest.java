package com.binance4j.margin.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.OCOOrderRecord;

import retrofit2.Call;

/** {@link MarginClient#getOrder} request. */
@GetRequest(path = "/sapi/v1/margin/orderList", signature = Signature.USER_DATA, weight = 10)
public class GetOCORequest extends Request<OCOOrderRecord> {
	/**
	 * @param call the retrofit call
	 */
	public GetOCORequest(Call<OCOOrderRecord> call) {
		super(call);
	}
}
