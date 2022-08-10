package com.binance4j.wallet.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.dto.WalletTransferHistory;

import retrofit2.Call;

/** {@link WalletClient#getTransferHistory} request. */
@GetRequest(path = "/sapi/v1/asset/transfer", signature = Signature.USER_DATA)
public class GetTransferHistoryRequest extends Request<WalletTransferHistory> {
	/**
	 * @param call the retrofit call
	 */
	public GetTransferHistoryRequest(Call<WalletTransferHistory> call) {
		super(call);
	}
}
