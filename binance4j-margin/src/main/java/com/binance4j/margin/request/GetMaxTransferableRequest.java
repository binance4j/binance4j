package com.binance4j.margin.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.MaxTransferable;

import retrofit2.Call;

/** {@link MarginClient#getMaxBorrowable} request. */
@GetRequest(path = "/sapi/v1/margin/maxTransferable", signature = Signature.USER_DATA, weight = 50)
public class GetMaxTransferableRequest extends Request<MaxTransferable> {
	/**
	 * @param call the retrofit call
	 */
	public GetMaxTransferableRequest(Call<MaxTransferable> call) {
		super(call);
	}
}
