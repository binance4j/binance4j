package com.binance4j.wallet.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.dto.AccountStatus;

import retrofit2.Call;

/** {@link WalletClient#getAccountStatus} request. */
@GetRequest(path = "/sapi/v1/account/status", signature = Signature.USER_DATA)
public class GetAccountStatus extends Request<AccountStatus> {
	/**
	 * @param call the retrofit call
	 */
	public GetAccountStatus(Call<AccountStatus> call) {
		super(call);
	}
}
