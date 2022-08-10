package com.binance4j.nft.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.dto.Signature;
import com.binance4j.nft.client.NFTClient;
import com.binance4j.nft.dto.TransactionHistory;

import retrofit2.Call;

/** {@link NFTClient#getTransactions} request. */
@GetRequest(path = "/sapi/v1/nft/history/transactions", signature = Signature.USER_DATA, rateLimit = RateLimitType.UID, weight = 3000)
public class GetTransactionsRequest extends Request<TransactionHistory> {
	/**
	 * @param call the retrofit call
	 */
	public GetTransactionsRequest(Call<TransactionHistory> call) {
		super(call);
	}
}
