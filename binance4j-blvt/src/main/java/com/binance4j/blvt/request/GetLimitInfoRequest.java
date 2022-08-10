package com.binance4j.blvt.request;

import java.util.List;

import com.binance4j.blvt.client.BLVTClient;
import com.binance4j.blvt.dto.LimitInfo;
import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;

import retrofit2.Call;

/** {@link BLVTClient#getLimitInfo()} request. */
@GetRequest(path = "/sapi/v1/blvt/userLimit", signature = Signature.USER_DATA)
public class GetLimitInfoRequest extends Request<List<LimitInfo>> {
	/**
	 * @param call the retrofit call
	 */
	public GetLimitInfoRequest(Call<List<LimitInfo>> call) {
		super(call);
	}
}
