package com.binance4j.margin.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.OCOOrderRecord;

import retrofit2.Call;

/** {@link MarginClient#getOrder} request. */
@GetRequest(path = "/sapi/v1/margin/openOrderList", signature = Signature.USER_DATA, weight = 10)
public class GetOpenOCORequest extends Request<List<OCOOrderRecord>> {
	/**
	 * @param call the retrofit call
	 */
	public GetOpenOCORequest(Call<List<OCOOrderRecord>> call) {
		super(call);
	}
}
