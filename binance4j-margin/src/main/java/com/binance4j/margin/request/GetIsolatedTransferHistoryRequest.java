package com.binance4j.margin.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.IsolatedTransferRecords;

import retrofit2.Call;

/** {@link MarginClient#getAccount} request. */
@GetRequest(path = "/sapi/v1/margin/isolated/transfer", signature = Signature.USER_DATA, weight = 1)
public class GetIsolatedTransferHistoryRequest extends Request<IsolatedTransferRecords> {
	/**
	 * @param call the retrofit call
	 */
	public GetIsolatedTransferHistoryRequest(Call<IsolatedTransferRecords> call) {
		super(call);
	}
}
