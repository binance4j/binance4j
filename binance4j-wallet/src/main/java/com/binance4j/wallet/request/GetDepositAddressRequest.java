package com.binance4j.wallet.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.dto.DepositAddress;

import retrofit2.Call;

/** {@link WalletClient#getDepositAddress} request. */
@GetRequest(path = "/sapi/v1/capital/deposit/address", signature = Signature.USER_DATA, weight = 10)
public class GetDepositAddressRequest extends Request<DepositAddress> {
	/**
	 * @param call the retrofit call
	 */
	public GetDepositAddressRequest(Call<DepositAddress> call) {
		super(call);
	}
}
