package com.binance4j.wallet.request;

import java.util.List;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.dto.WithdrawHistory;

import retrofit2.Call;

/** {@link WalletClient#getWithdrawHistory} request. */
@GetRequest(path = "/sapi/v1/capital/withdraw/history", signature = Signature.USER_DATA)
public class GetWithdrawHistoryRequest extends Request<List<WithdrawHistory>> {
	/**
	 * @param call the retrofit call
	 */
	public GetWithdrawHistoryRequest(Call<List<WithdrawHistory>> call) {
		super(call);
	}
}
