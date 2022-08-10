package com.binance4j.margin.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.LoanRecord;

import retrofit2.Call;

/** {@link MarginClient#getLoanRecord} request. */
@GetRequest(path = "/sapi/v1/margin/loan", signature = Signature.USER_DATA, weight = 10)
public class GetLoanRecordRequest extends Request<LoanRecord> {
	/**
	 * @param call the retrofit call
	 */
	public GetLoanRecordRequest(Call<LoanRecord> call) {
		super(call);
	}
}
