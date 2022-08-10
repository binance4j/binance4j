package com.binance4j.wallet.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.dto.FuturesAccountSnapshotResponse;

import retrofit2.Call;

/** {@link WalletClient#getFuturesAccountSnapshot} request. */
@GetRequest(path = "/sapi/v1/accountSnapshot", signature = Signature.USER_DATA, weight = 2400)
public class GetFuturesAccountSnapshotRequest extends Request<FuturesAccountSnapshotResponse> {
	/**
	 * @param call the retrofit call
	 */
	public GetFuturesAccountSnapshotRequest(Call<FuturesAccountSnapshotResponse> call) {
		super(call);
	}
}
