package com.binance4j.wallet.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.PostRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.wallet.client.WalletClient;

import retrofit2.Call;

/** {@link WalletClient#disableFastWithdrawSwitch} request. */
@PostRequest(path = "/sapi/v1/account/disableFastWithdrawSwitch", signature = Signature.USER_DATA)
public class DisableFastWithdrawSwitchRequest extends Request<Void> {
	/**
	 * @param call the retrofit call
	 */
	public DisableFastWithdrawSwitchRequest(Call<Void> call) {
		super(call);
	}
}
