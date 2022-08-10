package com.binance4j.margin.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.RepayRecords;

import retrofit2.Call;

/** {@link MarginClient#getRepayRecord} request. */
@GetRequest(path = "/sapi/v1/margin/repay", signature = Signature.USER_DATA, weight = 10)
public class GetRepayRecordRequest extends Request<RepayRecords> {
	/**
	 * @param call the retrofit call
	 */
	public GetRepayRecordRequest(Call<RepayRecords> call) {
		super(call);
	}
}
