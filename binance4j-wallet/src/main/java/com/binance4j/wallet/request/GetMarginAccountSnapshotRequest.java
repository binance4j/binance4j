package com.binance4j.wallet.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.dto.MarginAccountSnapshotResponse;

import retrofit2.Call;

/** {@link WalletClient#getMarginAccountSnapshot} request. */
@GetRequest(path = "/sapi/v1/accountSnapshot", signature = Signature.USER_DATA, weight = 2400)
public class GetMarginAccountSnapshotRequest extends Request<MarginAccountSnapshotResponse> {
	/**
	 * @param call the retrofit call
	 */
	public GetMarginAccountSnapshotRequest(Call<MarginAccountSnapshotResponse> call) {
		super(call);
	}
}
