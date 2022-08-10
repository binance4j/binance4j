package com.binance4j.wallet.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.PostRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.dto.DustTransferResponse;

import retrofit2.Call;

/** {@link WalletClient#dustTransfer} request. */
@PostRequest(path = "/sapi/v1/asset/dust", signature = Signature.USER_DATA, weight = 10)
public class DustTransferRequest extends Request<DustTransferResponse> {
	/**
	 * @param call the retrofit call
	 */
	public DustTransferRequest(Call<DustTransferResponse> call) {
		super(call);
	}
}
