package com.binance4j.margin.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.PostRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.Transaction;

import retrofit2.Call;

/** {@link MarginClient#transfer} request. */
@PostRequest(path = "/sapi/v1/margin/transfer", signature = Signature.MARGIN, weight = 600)
public class TransferRequest extends Request<Transaction> {
	/**
	 * @param call the retrofit call
	 */
	public TransferRequest(Call<Transaction> call) {
		super(call);
	}
}
