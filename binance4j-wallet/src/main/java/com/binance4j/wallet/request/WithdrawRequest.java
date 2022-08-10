package com.binance4j.wallet.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.PostRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.dto.WithdrawResult;

import retrofit2.Call;

/** {@link WalletClient#withdraw} request. */
@PostRequest(path = "/sapi/v1/capital/withdraw/apply", signature = Signature.USER_DATA)
public class WithdrawRequest extends Request<WithdrawResult> {
	/**
	 * @param call the retrofit call
	 */
	public WithdrawRequest(Call<WithdrawResult> call) {
		super(call);
	}
}
