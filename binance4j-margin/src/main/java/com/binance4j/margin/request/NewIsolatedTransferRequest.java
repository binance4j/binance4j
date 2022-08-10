package com.binance4j.margin.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.PostRequest;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.dto.Signature;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.Transaction;

import retrofit2.Call;

/** {@link MarginClient#borrow} request. */
@PostRequest(path = "/sapi/v1/margin/isolated/transfer", rateLimit = RateLimitType.UID, signature = Signature.MARGIN, weight = 600)
public class NewIsolatedTransferRequest extends Request<Transaction> {
	/**
	 * @param call the retrofit call
	 */
	public NewIsolatedTransferRequest(Call<Transaction> call) {
		super(call);
	}
}
