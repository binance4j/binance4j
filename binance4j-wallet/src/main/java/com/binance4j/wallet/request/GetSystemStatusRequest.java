package com.binance4j.wallet.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.dto.SystemStatus;

import retrofit2.Call;

/** {@link WalletClient#getSystemStatus} request. */
@GetRequest(path = "/sapi/v1/system/status")
public class GetSystemStatusRequest extends Request<SystemStatus> {
	/**
	 * @param call the retrofit call
	 */
	public GetSystemStatusRequest(Call<SystemStatus> call) {
		super(call);
	}
}
