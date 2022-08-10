package com.binance4j.wallet.request;

import com.binance4j.core.Request;
import com.binance4j.core.annotation.GetRequest;
import com.binance4j.core.dto.Signature;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.dto.DustLog;

import retrofit2.Call;

/** {@link WalletClient#getDustLog} request. */
@GetRequest(path = "/sapi/v1/asset/dribblet", signature = Signature.USER_DATA)
public class GetDustLogRequest extends Request<DustLog> {
	/**
	 * @param call the retrofit call
	 */
	public GetDustLogRequest(Call<DustLog> call) {
		super(call);
	}
}
