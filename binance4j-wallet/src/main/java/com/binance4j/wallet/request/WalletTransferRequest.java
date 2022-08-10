package com.binance4j.wallet.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.PostRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.dto.WalletTransferResponse;

import retrofit2.Call;

/** {@link WalletClient#transfer} request. */
@PostRequest(path = "/sapi/v1/asset/transfer", signature = Signature.USER_DATA)
public class WalletTransferRequest extends Request<WalletTransferResponse> {
	/**
	 * @param call the retrofit call
	 */
	public WalletTransferRequest(Call<WalletTransferResponse> call) {
		super(call);
	}
}
