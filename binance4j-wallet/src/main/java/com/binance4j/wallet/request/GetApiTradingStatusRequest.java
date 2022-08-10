package com.binance4j.wallet.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.dto.ApiTradingStatus;

import retrofit2.Call;

/** {@link WalletClient#getApiTradingStatus} request. */
@GetRequest(path = "/sapi/v1/account/apiTradingStatus", signature = Signature.USER_DATA)
public class GetApiTradingStatusRequest extends Request<ApiTradingStatus> {
	/**
	 * @param call the retrofit call
	 */
	public GetApiTradingStatusRequest(Call<ApiTradingStatus> call) {
		super(call);
	}
}
