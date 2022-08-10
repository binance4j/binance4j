package com.binance4j.margin.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.TransferRecords;

import retrofit2.Call;

/** {@link MarginClient#getTransferHistory} request. */
@GetRequest(path = "/sapi/v1/margin/transfer", signature = Signature.USER_DATA)
public class GetTransferHistoryRequest extends Request<TransferRecords> {
	/**
	 * @param call the retrofit call
	 */
	public GetTransferHistoryRequest(Call<TransferRecords> call) {
		super(call);
	}
}
