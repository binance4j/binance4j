package com.binance4j.nft.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.dto.Signature;
import com.binance4j.nft.client.NFTClient;
import com.binance4j.nft.dto.WithdrawHistory;

import retrofit2.Call;

/** {@link NFTClient#getWithdraws} request. */
@GetRequest(path = "/sapi/v1/nft/history/withdraw", signature = Signature.USER_DATA, rateLimit = RateLimitType.UID, weight = 3000)
public class GetWithdrawsRequest extends Request<WithdrawHistory> {
	/**
	 * @param call the retrofit call
	 */
	public GetWithdrawsRequest(Call<WithdrawHistory> call) {
		super(call);
	}
}
