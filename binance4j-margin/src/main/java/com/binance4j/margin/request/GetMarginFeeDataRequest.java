package com.binance4j.margin.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.CrossFee;

import retrofit2.Call;

/** {@link MarginClient#getMarginFeeData} request. */
@GetRequest(path = "/sapi/v1/margin/crossMarginData", signature = Signature.USER_DATA)
public class GetMarginFeeDataRequest extends Request<List<CrossFee>> {
	/**
	 * @param call the retrofit call
	 */
	public GetMarginFeeDataRequest(Call<List<CrossFee>> call) {
		super(call);
	}
}
