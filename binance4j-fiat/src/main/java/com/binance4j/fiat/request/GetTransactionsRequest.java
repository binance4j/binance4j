package com.binance4j.fiat.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.dto.Signature;
import com.binance4j.fiat.client.FiatClient;
import com.binance4j.fiat.dto.TransactionHistory;

import retrofit2.Call;

/** {@link FiatClient#getTransactions} request. */
@GetRequest(path = "/sapi/v1/fiat/orders", rateLimit = RateLimitType.UID, signature = Signature.USER_DATA, weight = 90000)
public class GetTransactionsRequest extends Request<TransactionHistory> {
	/**
	 * @param call the retrofit call
	 */
	public GetTransactionsRequest(Call<TransactionHistory> call) {
		super(call);
	}
}
